package com.ms.currency.controller;

import java.time.LocalDateTime;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.currency.entity.CurrencyConversion;
import com.ms.currency.feignClient.FeignClientCode;
import com.ms.currency.repository.CurrencyRepository;
import com.sathya.exchange.entity.CurrencyExchange;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/v1")
public class CurrencyServiceController {
	@Autowired 
	CurrencyRepository currencyRepository;
	
	@Autowired
	FeignClientCode feignClientCode;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	@CircuitBreaker(name = "currencyService", fallbackMethod = "currencyExchangeFallback")
	public ResponseEntity<CurrencyConversion> calculateCurrencyConversion(
            @PathVariable String from, @PathVariable String to,
            @PathVariable int quantity) {
 
		 CurrencyExchange currencyExchange = feignClientCode.retrieveExchangeValue(from, to);
		 Double conversionMultiple = currencyExchange.getConversionMultiple();
		
		  double totalCalculatedAmount = quantity * conversionMultiple;
		    CurrencyConversion currencyConversion = new CurrencyConversion();
	        currencyConversion.setFromCurrency(from);
	        currencyConversion.setToCurrency(to);
	        currencyConversion.setQuantity(quantity);
	        currencyConversion.setConversionMultiple(conversionMultiple);
	        currencyConversion.setTotalCalculatedAmount(totalCalculatedAmount);
	        currencyConversion.setLocatDateTime(LocalDateTime.now());
	        
	        currencyRepository.save(currencyConversion);
	        return ResponseEntity.status(HttpStatus.SC_OK)
                    .header("value", "amount calculated....")
                    .body(currencyConversion);
	}
	
	
	public ResponseEntity<CurrencyConversion> currencyExchangeFallback(
	        String from, String to, int quantity, Throwable ex) {

	    // Log the exception if needed
	    System.out.println("Fallback triggered for from = " + from + ", to = " + to + " due to " + ex.getMessage());

	    // Provide a default response or a custom fallback response
	    CurrencyExchange fallbackResponse = new CurrencyExchange();
	    fallbackResponse.setFromCurrency(from);
	    fallbackResponse.setToCurrency(to);
	    fallbackResponse.setConversionMultiple(0.0);  // Default value if the service is down
	    
	    CurrencyConversion currencyConversion = new CurrencyConversion();
	    currencyConversion.setFromCurrency(from);
	    currencyConversion.setToCurrency(to);
	    currencyConversion.setQuantity(quantity);
	    currencyConversion.setConversionMultiple(fallbackResponse.getConversionMultiple());
	    currencyConversion.setTotalCalculatedAmount(quantity * fallbackResponse.getConversionMultiple());
	    currencyConversion.setLocatDateTime(LocalDateTime.now());
	    
	    // You can optionally log or save the failed conversion if needed
	    return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
	            .header("value", "Fallback: currency conversion failed due to service unavailability")
	            .body(currencyConversion);
	}
	  
}



