package com.stockmonitor.service;

import java.math.BigDecimal;
import java.util.List;

import com.stockmonitor.entity.StockAccount;
import com.stockmonitor.entity.StockTransaction;

public interface TransactionService {

    public List<StockTransaction> getAllStockTransactions();
    
    public void buyStock(StockAccount stockAccount, BigDecimal stockPrice);
    
    public void sellStock(StockAccount stockAccount, BigDecimal stockPrice);
}