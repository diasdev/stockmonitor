package com.stockmonitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockMonitorExecutor {

    private static final Logger log = LoggerFactory.getLogger(StockMonitorExecutor.class);

    private int OperationsLimit
    
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        
    	
    	log.info("checking stock prices");
    }
}