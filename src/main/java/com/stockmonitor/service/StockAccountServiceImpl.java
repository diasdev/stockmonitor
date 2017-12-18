package com.stockmonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockmonitor.entity.StockAccount;
import com.stockmonitor.repository.StockAccountRepository;

@Component
public class StockAccountServiceImpl implements StockAccountService {

	@Autowired
	private StockAccountRepository stockAccountRepo; 
	
    public List<StockAccount> getAllStockAccount(){
    	return stockAccountRepo.findAll();
    }
    
    public StockAccount addStockAccount(StockAccount stockAccount) throws Exception {
    	if (stockAccount.getSellingPrice().compareTo(stockAccount.getBuyingPrice()) >= 0)
    		return stockAccountRepo.save(stockAccount);
    	else
    		throw new Exception();
    }
    
    public void updateStockAccount(StockAccount stockAccount) {
    	stockAccountRepo.save(stockAccount);
    }
}