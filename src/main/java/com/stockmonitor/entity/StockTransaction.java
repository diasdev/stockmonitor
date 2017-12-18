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
	
	@Column(name="stock__amount_traded")
    private int stockAmountTraded;
	
	@Column(name="currency_amount_traded")
    private BigDecimal currencyAmountTraded;
	
	@Column(name="operation")
    private StockOperation operation;

	public long getID() {
		return this.ID;
	}
	
	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String value) {
		this.accountEmail = value;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String value) {
		this.companyCode = value;
	}
	
	public StockOperation getOperation() {
		return operation;
	}

	public void setOperation(StockOperation value) {
		this.operation = value;
	}

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal value) {
		this.stockPrice = value;
	}

	public int getStockAmountTraded() {
		return stockAmountTraded;
	}

	public void setStockAmountTraded(int value) {
		this.stockAmountTraded = value;
	}

	public BigDecimal getCurrencyAmountTraded() {
		return currencyAmountTraded;
	}

	public void setCurrencyAmountTraded(BigDecimal value) {
		this.currencyAmountTraded = value;
	}
    
}