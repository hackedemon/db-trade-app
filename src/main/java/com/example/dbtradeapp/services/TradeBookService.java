package com.example.dbtradeapp.services;

import com.example.dbtradeapp.entities.TradeBook;

public interface TradeBookService {

	void addTrade(TradeBook tradeBook);

	TradeBook getById(String tradeId, Integer version);
	
}
