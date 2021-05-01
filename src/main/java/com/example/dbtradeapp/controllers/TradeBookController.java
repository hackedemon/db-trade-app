package com.example.dbtradeapp.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbtradeapp.dtos.TradeBookGetDTO;
import com.example.dbtradeapp.dtos.TradeBookPostDTO;
import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.services.TradeBookService;

@RestController
@RequestMapping("/trade-book")
public class TradeBookController {

	@Autowired
	private TradeBookService service;
	
	/**
	 * Controller which returns the value of trade based on composite keys.
	 * @param tradeId
	 * @param version
	 * @return
	 */
	@GetMapping("/trade-id/{trade-id}/version/{version}")
	public TradeBookGetDTO getTradeBookById(
										@PathVariable(name = "trade-id") String tradeId,
										@Min(value = 1, message = "{version.min}") @PathVariable(name = "version") Integer version
	) {
		return getTradeBookGetDTO(service.getById(tradeId, version));
	}
	
	/**
	 * Controller method to create/update trades.
	 * @param book
	 * @return
	 */
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public EntityModel<TradeBookGetDTO> addTrade(@Valid @RequestBody TradeBookPostDTO book) {
		TradeBook tradeBook = getTradeBook(book);
		TradeBookGetDTO tradeBookGetDTO = getTradeBookGetDTO(service.addTrade(tradeBook));
		EntityModel<TradeBookGetDTO> resource = EntityModel.of(tradeBookGetDTO);
		resource.add(linkTo(methodOn(this.getClass()).getTradeBookById(tradeBookGetDTO.getTradeId(), tradeBookGetDTO.getVersion()))
				.withRel("trade"));
		return resource;
	}
	
	private TradeBookGetDTO getTradeBookGetDTO(TradeBook tradeBook) {
		return TradeBookGetDTO.builder()
				.bookId(tradeBook.getBookId())
				.counterPartyId(tradeBook.getCounterPartyId())
				.maturityDate(tradeBook.getMaturityDate())
				.tradeId(tradeBook.getTradeId())
				.version(tradeBook.getVersion())
				.createdDate(tradeBook.getCreatedDate())
				.expired(tradeBook.isExpired())
				.build();
	}
	
	@SuppressWarnings("unused")
	private TradeBook getTradeBook(TradeBookGetDTO tradeBookGetDTO) {
		return TradeBook.builder()
				.bookId(tradeBookGetDTO.getBookId())
				.counterPartyId(tradeBookGetDTO.getCounterPartyId())
				.maturityDate(tradeBookGetDTO.getMaturityDate())
				.tradeId(tradeBookGetDTO.getTradeId())
				.version(tradeBookGetDTO.getVersion())
				.createdDate(tradeBookGetDTO.getCreatedDate())
				.expired(tradeBookGetDTO.isExpired())
				.build();
	}
	
	@SuppressWarnings("unused")
	private TradeBookPostDTO getTradeBookPostDTO(TradeBook tradeBook) {
		return TradeBookPostDTO.builder()
				.bookId(tradeBook.getBookId())
				.counterPartyId(tradeBook.getCounterPartyId())
				.maturityDate(tradeBook.getMaturityDate())
				.tradeId(tradeBook.getTradeId())
				.version(tradeBook.getVersion())
				.build();
	}
	
	private TradeBook getTradeBook(TradeBookPostDTO tradeBookPostDTO) {
		return TradeBook.builder()
				.bookId(tradeBookPostDTO.getBookId())
				.counterPartyId(tradeBookPostDTO.getCounterPartyId())
				.maturityDate(tradeBookPostDTO.getMaturityDate())
				.tradeId(tradeBookPostDTO.getTradeId())
				.version(tradeBookPostDTO.getVersion())
				.build();
	}
}
