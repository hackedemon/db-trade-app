package com.example.dbtradeapp.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.entities.composite.TradeBookId;

@Repository
public interface TradeBookRepo extends JpaRepository<TradeBook, TradeBookId> {

	/**
	 * Fetches all entities filtered by tradeId.
	 * @param tradeId
	 * @return
	 */
	Optional<List<TradeBook>> findByTradeId(String tradeId);
	
	/**
	 * Fetches all entities less than maturity date.
	 * @param maturityDate
	 * @return
	 */
	Optional<List<TradeBook>> findByMaturityDateLessThan(LocalDate maturityDate);
	
}
