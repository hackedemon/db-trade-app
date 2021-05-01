package com.example.dbtradeapp.services;

import java.time.LocalDate;
import java.util.List;

import com.example.dbtradeapp.entities.TradeBook;

public interface TradeBookService {

	/**
	 * Create/update trades in after all validations are passed.
	 * @param tradeBook
	 * @return
	 */
	TradeBook addTrade(TradeBook tradeBook);

	/**
	 * Get trade using composite key from database.
	 * @param tradeId
	 * @param version
	 * @return
	 */
	TradeBook getById(String tradeId, Integer version);

	/**
	 * Get all trades whose maturity date is less than the entered date.
	 * @param maturityDate
	 * @return
	 */
	List<TradeBook> getAllTradesLessThanMaturityDate(LocalDate maturityDate);

	/**
	 * Method to make update to existing trade.
	 * @param tradeBook
	 */
	void updateTrade(TradeBook tradeBook);
	
}
