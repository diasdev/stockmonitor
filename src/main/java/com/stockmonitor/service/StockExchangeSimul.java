package com.stockmonitor.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeSimul {

    private static final Logger log = LoggerFactory.getLogger(StockExchangeSimul.class);

    public Map<String, Double> getStockPrices() {
        log.info("generating random stock prices");
        
        return new HashMap<String, Double>();
    }
}