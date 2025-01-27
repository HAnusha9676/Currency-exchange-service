package com.ms.currency.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sathya.exchange.entity.CurrencyExchange;

// Ensure the name matches the service you're calling, or the URL directly if not using service discovery
@FeignClient(name = "currency-exchange")
public interface FeignClientCode {

    // Define the endpoint and path variables
    @GetMapping("/api/v1/from/{from}/to/{to}")
    CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
