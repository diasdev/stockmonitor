package com.stockmonitor.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockmonitor.entity.Account;
import com.stockmonitor.entity.StockAccount;
import com.stockmonitor.entity.StockTransaction;
import com.stockmonitor.repository.AccountRepository;
import com.stockmonitor.repository.StockAccountRepository;
import com.stockmonitor.repository.TransactionRepository;
import com.stockmonitor.util.StockOperation;

@Component
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private StockAccountRepository stockAccountRepo;
	
	private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
    public List<StockTransaction> getAllStockTransactions(){
    	return transactionRepo.findAll();
    }
    
    public void sellStock(StockAccount stockAccount, BigDecimal stockPrice) {
    	int stockAmount = stockAccount.getStockAmount();
    	
    	if (stockAmount > 0) {
    		BigDecimal soldValue = stockPrice.multiply(new BigDecimal(stockAmount));
        	
        	stockAccount.setStockAmount(0);
        	stockAccountRepo.saveAndFlush(stockAccount);
        	
        	Account account = accountRepo.findByAccountEmail(stockAccount.getAccount().getAccountEmail());
        	BigDecimal balance = account.getBalance().add(soldValue); 
        	account.setBalance(balance);
        	accountRepo.saveAndFlush(account);
        	
        	StockTransaction newTransaction = new StockTransaction();
    		newTransaction.setAccountEmail(stockAccount.getAccount().getAccountEmail());
    		newTransaction.setCompanyCode(stockAccount.getCompany().getCompanyCode());
    		newTransaction.setOperation(StockOperation.SELL);
    		newTransaction.setStockPrice(stockPrice);
    		newTransaction.setStockAmountTraded(stockAmount);
    		newTransaction.setCurrencyAmountTraded(soldValue);
    		
    		addTransaction(newTransaction);
    	}
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
    		
    		StockTransaction newTransaction = new StockTransaction();
    		newTransaction.setAccountEmail(stockAccount.getAccount().getAccountEmail());
    		newTransaction.setCompanyCode(stockAccount.getCompany().getCompanyCode());
    		newTransaction.setOperation(StockOperation.BUY);
    		newTransaction.setStockPrice(stockPrice);
    		newTransaction.setStockAmountTraded(numberOfStocksToBuy);
    		newTransaction.setCurrencyAmountTraded(boughtValue);
    		
    		addTransaction(newTransaction);
    	}
    }
    
    private void addTransaction(StockTransaction stockTransaction) {
    	StockTransaction createdTransaction = transactionRepo.saveAndFlush(stockTransaction);
    	
    	log.info("saving transaction: " + createdTransaction.getID());
    	
    	if (createdTransaction.getID() == 0) {
    		log.info("100th transaction");
    	}
    }
    
}