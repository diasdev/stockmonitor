package com.stockmonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stockmonitor.entity.Account;
import com.stockmonitor.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public List<Account> getAccounts(){
		return accountRepo.findAll();
	}
}
