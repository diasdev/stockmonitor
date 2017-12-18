package com.stockmonitor.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "STOCK_ACCOUNT",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"account_email", "company_code"})} )
public class StockAccount {

	@Id
    @GeneratedValue
    @Column(name = "ID")
	private int ID;
	
	@ManyToOne
    @JoinColumn(name = "account_email")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "company_code")
    private Company company;

    @Column(name = "buying_price")
    private BigDecimal buyingPrice;
    
    @Column(name = "selling_price")
    private BigDecimal sellingPrice;
    
    @Column(name = "stock_amount")
    private int stockAmount;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	public BigDecimal getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(BigDecimal value) {
		this.buyingPrice = value;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal value) {
		this.sellingPrice = value;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
	
}