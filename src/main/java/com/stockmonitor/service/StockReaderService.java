package com.stockmonitor.service;

import java.util.List;
import com.stockmonitor.util.StockPrice;

public interface StockReaderService {

    public List<StockPrice> getStockPrices(); 
}