package com.example.dbtradeapp.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.entities.composite.TradeBookId;

@Repository
public interface TradeBookRepo extends JpaRepository<TradeBook, TradeBookId> {

	Optional<List<TradeBook>> findByTradeId(String tradeId);
	
}
