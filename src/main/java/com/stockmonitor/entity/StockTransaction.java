package com.stockmonitor.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stockmonitor.util.StockOperation;

@Entity
@Table(name = "STOCK_TRANSACTION")
public class StockTransaction {

	@Id
    @GeneratedValue
    @Column(name = "ID")
	private long ID;
	
	@Column(name="account_email")
	private String accountEmail;
	
	@Column(name="company_code")
	private String companyCode;
	
	@Column(name="stock_price")
    private BigDecimal stockPrice;
	
	@Column(name="operation")
    private StockOperation operation;

	public long getID() {
		return this.ID;
	}
	
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

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	
    
}