package com.stockmonitor.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.stockmonitor.entity.StockTransaction;

public final class TransactionReport {
	private TransactionReport() {
		
	}
	
	public static void createTransactionReportFile(List<StockTransaction> listTransactions, String pathName) throws IOException  {
		Path filePath = Paths.get(pathName);
	    
	    try (BufferedWriter writer = 
	    		Files.newBufferedWriter(filePath)) {

	    	for (StockTransaction transaction: listTransactions) {

                String newLine = System.getProperty("line.separator");
                
                String transactionEntry =	"ID da transação: " + transaction.getID() + 	
                							" Email: " + transaction.getAccountEmail() +
                							" Company: " + transaction.getCompanyCode() +
                							" Total negociado: " + transaction.getCurrencyAmountTraded() + 
                							" Total de ações negociadas: " + transaction.getStockAmountTraded() +
                							" Tipo de operação: " + transaction.getOperation().toString() +
                							" Ao preço de: " + transaction.getStockPrice().toString() +
                							newLine;
                writer.write(transactionEntry);
            }
	    }
	}
	
	public static void sendEmailNotification() {
		//TODO
	}
	
}