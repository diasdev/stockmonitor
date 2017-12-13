package com.stockmonitor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_TRANSACTION")
public class StockTransaction {

	@Id
    @GeneratedValue
    @Column(name = "ID")
	private int ID;
	
	@Column(name="account_email", unique = true)
	private String accountEmail;
	
	@Column(name="company_code", unique = true)
	private String companyCode;
	
	@Column(name="stock_price")
    private Double stockPrice;
	
	@Column(name="operation")
    private StockOperation operation;

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	public StockOperation getOperation() {
		return operation;
	}

	public void setOperation(StockOperation operation) {
		this.operation = operation;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	
    
}