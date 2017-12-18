package com.stockmonitor.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.stockmonitor.service.StockMonitorService;

@Component
public class StockMonitorExecutor {

    private static final Logger log = LoggerFactory.getLogger(StockMonitorExecutor.class);
    
    @Autowired
    private StockMonitorService monitor;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    	log.info("checking stock prices");
    	
    	monitor.EvaluateStockPrices();
    }
}