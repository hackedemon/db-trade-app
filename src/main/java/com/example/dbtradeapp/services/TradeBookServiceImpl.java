package com.example.dbtradeapp.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.entities.composite.TradeBookId;
import com.example.dbtradeapp.exceptions.InvalidDataException;
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
		if (tradeBook.getMaturityDate().compareTo(LocalDate.now()) < 0) {
			throw new InvalidDataException(
					"Invalid maturity date, enter value equal or greater than today's date. Trade rejected");
		}
		repo.findByTradeId(tradeBook.getTradeId()).ifPresent(list -> list.forEach(tb -> {
			if (tb.getVersion() > tradeBook.getVersion()) {
				throw new InvalidDataException("Lower version received. Trade rejected");
			}
		}));
		repo.save(tradeBook);
	}

}
