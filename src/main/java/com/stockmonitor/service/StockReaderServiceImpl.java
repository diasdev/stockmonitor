package com.stockmonitor.service;

import com.stockmonitor.util.StockPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockmonitor.repository.CompanyRepository;
import com.stockmonitor.entity.Company;

@Component
public class StockReaderServiceImpl implements StockReaderService{

	@Autowired
	private CompanyRepository companyRepo;
	
	private static List<Company> companyList;
	private static List<StockPrice> stockPriceList;
	
    private static final Logger log = LoggerFactory.getLogger(StockReaderServiceImpl.class);

    public List<StockPrice> getStockPrices() {
        log.info("generating random stock prices");

        if (companyList == null) {
        	companyList = companyRepo.findAll();
        }
        
        if (stockPriceList == null) {
        	stockPriceList = new ArrayList<StockPrice>();
        	companyList.forEach(c -> stockPriceList.add(
        							new StockPrice(c.getCompanyCode(), BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(10, 20)))
        						));
        }
        else {
        	stockPriceList.forEach(sp -> sp.setPrice(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(10, 20))));
        }
        
        return stockPriceList;
    }
}