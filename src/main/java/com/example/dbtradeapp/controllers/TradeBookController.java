package com.example.dbtradeapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.services.TradeBookService;

@RestController
@RequestMapping("/trade-book")
public class TradeBookController {

	@Autowired
	private TradeBookService service;
	
	@GetMapping("/trade-id/{trade-id}/version/{version}")
	public TradeBook getTradeBookById(
										@PathVariable(name = "trade-id") String tradeId,
										@PathVariable(name = "version") Integer version
	) {
		return service.getById(tradeId, version);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addTrade(@Valid @RequestBody TradeBook book) {
		service.addTrade(book);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
