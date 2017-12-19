package com.stockmonitor.util;

public enum StockOperation {
    BUY("Compra"), SELL("Venda");
	
	private final String operationType;

    private StockOperation(String value) {
    	operationType = value;
    }

    public String getOperationType() {
        return operationType;
    }
}