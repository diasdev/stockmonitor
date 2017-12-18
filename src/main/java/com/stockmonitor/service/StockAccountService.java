package com.stockmonitor.service;

import java.util.List;

import com.stockmonitor.entity.StockAccount;

public interface StockAccountService {

    public List<StockAccount> getAllStockAccount();
    
    public StockAccount addStockAccount(StockAccount stockAccount) throws Exception;
    
    public void updateStockAccount(StockAccount stockAccount);
}