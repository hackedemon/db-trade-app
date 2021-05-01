package com.example.dbtradeapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.dbtradeapp.dtos.TradeBookGetDTO;
import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.services.TradeBookService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TradeBookControllerTest {

	@LocalServerPort
	private int port;
	
	@Mock
	private TradeBookService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	TradeBook entity;

	@BeforeEach
	public void setup() {
		entity = new TradeBook("T1", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"), LocalDate.parse("2021-04-28"),
				false);
	}
	
	@Test
	public void getByTradeBookId_test() throws RestClientException, URISyntaxException {
		ResponseEntity<TradeBookGetDTO> response = restTemplate.getForEntity(new URI("http://localhost:" + port
				+ "/trade-book/trade-id/" + entity.getTradeId() + "/version/" + entity.getVersion()),
				TradeBookGetDTO.class);
		when(service.getById(any(String.class), any(Integer.class))).thenReturn(entity);

		System.out.println(response.getBody());
		assertEquals(getTradeBookGetDTO(entity), response.getBody());
	}
	
	@Test
	public void addTrade_test() throws RestClientException, URISyntaxException {
		ResponseEntity<Object> response = restTemplate.postForEntity(new URI("http://localhost:" + port + "/trade-book/add"), entity, Object.class);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void addTrade_errorTest() throws Exception {
		entity.setTradeId("");
		mockMvc.perform(MockMvcRequestBuilders.post("/trade-book/add")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(entity.toString()))
	            .andExpect(MockMvcResultMatchers.status().isBadRequest());
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
	
}
