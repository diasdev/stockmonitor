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
import org.springframework.core.env.Environment;

import com.stockmonitor.repository.CompanyRepository;
import com.stockmonitor.entity.Company;

@Component
public class StockReaderServiceImpl implements StockReaderService{

	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
    private Environment environment;
	
	private static List<Company> companyList;
	private static List<StockPrice> stockPriceList;
	
    private static final Logger log = LoggerFactory.getLogger(StockReaderServiceImpl.class);

    public List<StockPrice> getStockPrices() {
        log.info("generating random stock prices");

        double min = Double.parseDouble(environment.getProperty("stockmonitor.minprice", "10"));
        double max = Double.parseDouble(environment.getProperty("stockmonitor.maxprice", "20"));
        
        if (companyList == null) {
        	companyList = companyRepo.findAll();
        }
        
        if (stockPriceList == null) {
        	stockPriceList = new ArrayList<StockPrice>();
        	companyList.forEach(c -> stockPriceList.add(
        							new StockPrice(c.getCompanyCode(), BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(min, max)))
        						));
        }
        else {
        	stockPriceList.forEach(sp -> 
        							sp.setPrice(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(min, max))));
        	
        	//second strategy: generate new random prices ranging from -2 to +2 relative to the current price
        	/*ThreadLocalRandom.current().nextDouble(
					sp.getPrice().subtract(new BigDecimal(1)).doubleValue(), 
					sp.getPrice().add(new BigDecimal(1)).doubleValue())*/
        	
        }
        
        return stockPriceList;
    }
}