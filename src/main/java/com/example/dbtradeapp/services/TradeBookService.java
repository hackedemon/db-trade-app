package com.example.dbtradeapp.services;

import java.time.LocalDate;
import java.util.List;

import com.example.dbtradeapp.entities.TradeBook;

public interface TradeBookService {

	void addTrade(TradeBook tradeBook);

	TradeBook getById(String tradeId, Integer version);

	List<TradeBook> getAllTradesLessThanMaturityDate(LocalDate maturityDate);

	void updateTrade(TradeBook tradeBook);
	
}
