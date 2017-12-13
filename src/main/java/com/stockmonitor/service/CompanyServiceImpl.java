package com.stockmonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stockmonitor.entity.Company;
import com.stockmonitor.repository.CompanyRepository;

public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository companyRepo;
	
	@Override
	public List<Company> getCompanies(){
		return companyRepo.findAll();
	}
}
