package com.example.dbtradeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.entities.composite.TradeBookId;
import com.example.dbtradeapp.repos.TradeBookRepo;

@Service
public class TradeBookServiceImpl implements TradeBookService {
	
	@Autowired
	private TradeBookRepo repo;

	@Override
	public TradeBook getById(String tradeId, Integer version) {
		TradeBookId bookId = new TradeBookId(tradeId, version);
		return repo.findById(bookId).get();
	}

	@Override
	public void addTrade(TradeBook tradeBook) {
		repo.save(tradeBook);
	}

}
