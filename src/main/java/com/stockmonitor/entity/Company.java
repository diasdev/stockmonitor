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
public class Company {

	@Id
	@Column(name="company_code", unique = true)
	private String companyCode;
	
	@Column(name="company_name")
	private String companyName;
	
	@OneToMany(mappedBy = "company")
	private Set<StockAccount> stockAccount = new HashSet<StockAccount>();

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<StockAccount> getStockAccount() {
        return stockAccount;
    }
}