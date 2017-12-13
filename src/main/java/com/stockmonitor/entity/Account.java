package com.stockmonitor.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Account {

	@Id
	@Column(name="account_email", unique = true)
	private String accountEmail;
	
	@Column
	private Double balance;
	
	@OneToMany(mappedBy = "account")
	private Set<StockAccount> stockAccount = new HashSet<StockAccount>();

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Set<StockAccount> getUserGroups() {
        return stockAccount;
    }
    
}