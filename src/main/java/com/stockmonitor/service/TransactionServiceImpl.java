package com.stockmonitor.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stockmonitor.entity.Account;
import com.stockmonitor.entity.StockAccount;
import com.stockmonitor.entity.StockTransaction;
import com.stockmonitor.repository.AccountRepository;
import com.stockmonitor.repository.StockAccountRepository;
import com.stockmonitor.repository.TransactionRepository;

public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private StockAccountRepository stockAccountRepo;
	
    public List<StockTransaction> getAllStockTransactions(){
    	return transactionRepo.findAll();
    }
    
    public void sellStock(StockAccount stockAccount, BigDecimal stockPrice) {
    	int stockAmount = stockAccount.getStockAmount();
    	BigDecimal soldValue = stockPrice.multiply(new BigDecimal(stockAmount));
    	
    	stockAccount.setStockAmount(0);    	
    	stockAccountRepo.saveAndFlush(stockAccount);
    	
    	Account account = accountRepo.findByAccountEmail(stockAccount.getAccount().getAccountEmail());
    	BigDecimal balance = account.getBalance().add(soldValue); 
    	account.setBalance(balance);
    	accountRepo.saveAndFlush(account);
    	
    }
    
    public void buyStock(StockAccount stockAccount, BigDecimal stockPrice) {
    	Account account = accountRepo.findByAccountEmail(stockAccount.getAccount().getAccountEmail());
    	BigDecimal accountBalance = account.getBalance();
    	
    	if (accountBalance.compareTo(stockPrice) >= 0) {
    		int numberOfStocksToBuy = accountBalance.divideToIntegralValue(stockPrice).intValue();
    		stockAccount.setStockAmount(stockAccount.getStockAmount() + numberOfStocksToBuy);
    		stockAccountRepo.saveAndFlush(stockAccount);
    		
    		BigDecimal boughtValue = stockPrice.multiply(new BigDecimal(numberOfStocksToBuy));
    		accountBalance = accountBalance.subtract(boughtValue);
    		account.setBalance(accountBalance);
    		accountRepo.saveAndFlush(account);
    	}
    }
    
    private void addTransaction(StockTransaction stockTransaction) {
    	StockTransaction createdTransaction = transactionRepo.saveAndFlush(stockTransaction);
    	
    	if (createdTransaction.getID() % 100 == 0) {
    		//create report
    	}
    }
    
}