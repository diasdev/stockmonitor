package com.stockmonitor.util;

import java.math.BigDecimal;

public class StockPrice {
	
	private String companyCode;
	private BigDecimal price;
	
	public StockPrice(String companyCode, BigDecimal price) {
		this.companyCode = companyCode;
		this.price = price;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}
	
	public void setCompanyCode (String value) {
		this.companyCode = value; 
	}
		
	public BigDecimal getPrice() {
		return this.price;
	}
	
	public void setPrice (BigDecimal value) {
		this.price = value; 
	}
}