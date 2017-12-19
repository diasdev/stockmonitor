package com.stockmonitor.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockmonitor.entity.StockAccount;
import com.stockmonitor.repository.StockAccountRepository;
import com.stockmonitor.util.StockPrice;

@Component
public class StockMonitorServiceImpl implements StockMonitorService {

	@Autowired
	private StockReaderService stockReader;
	
	@Autowired
	private StockAccountService stockAccountService;
	
	@Autowired
	private TransactionService transactionService;
	
    public void EvaluateStockPrices() {
    	List<StockPrice> stockPrices = stockReader.getStockPrices();
    	
    	List<StockAccount> stockMonitorings = stockAccountService.getAllStockAccount();

    	for (StockPrice sp:stockPrices) {

    		//find sellers for this stock (i.e. current price is greater than or equal to my selling price
    		List<StockAccount> sellers = stockMonitorings.stream()
    													.filter(sm ->	sm.getCompany().getCompanyCode() == sp.getCompanyCode() &&
    															sp.getPrice().compareTo(sm.getSellingPrice()) >= 0 )
    													.collect(Collectors.toList());
    		sellStocks(sellers, sp.getPrice());
    		
    		//find buyers for this stock (i.e. current price is less than or equal to my buying price
    		List<StockAccount> buyers = stockMonitorings.stream()
														.filter(sm ->	sm.getCompany().getCompanyCode() == sp.getCompanyCode() &&
																		sp.getPrice().compareTo(sm.getBuyingPrice()) <= 0 )
														.collect(Collectors.toList());
    		buyStocks(buyers, sp.getPrice());
    	}
    }
    
    private void sellStocks(List<StockAccount> sellers, BigDecimal stockPrice) {
    	sellers.forEach(b -> transactionService.sellStock(b, stockPrice));
    }
    
    private void buyStocks(List<StockAccount> buyers, BigDecimal stockPrice) {
    	buyers.forEach(b -> transactionService.buyStock(b, stockPrice));
    }
}