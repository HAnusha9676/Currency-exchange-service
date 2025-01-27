package com.ms.currency.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fromCurrency;
	private String toCurrency;
	private Double conversionMultiple;
	private Double totalCalculatedAmount;
	private Integer quantity;
	private LocalDateTime locatDateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public Double getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(Double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public Double getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(Double totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getLocatDateTime() {
		return locatDateTime;
	}
	public void setLocatDateTime(LocalDateTime locatDateTime) {
		this.locatDateTime = locatDateTime;
	}
	public CurrencyConversion(Long id, String fromCurrency, String toCurrency, Double conversionMultiple,
			Double totalCalculatedAmount, Integer quantity, LocalDateTime locatDateTime) {
	
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.quantity = quantity;
		this.locatDateTime = locatDateTime;
	}
	public CurrencyConversion() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency
				+ ", conversionMultiple=" + conversionMultiple + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", quantity=" + quantity + ", locatDateTime=" + locatDateTime + "]";
	}
	
	
	
	

}
