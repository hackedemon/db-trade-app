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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.services.TradeBookService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TradeBookControllerTest {

	@LocalServerPort
	private int port;
	
	@Mock
	private TradeBookService service;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	TradeBook entity;

	@BeforeEach
	public void setup() {
		entity = new TradeBook("T1", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"), LocalDate.parse("2021-04-28"),
				false);
	}
	
	@Test
	public void getByTradeBookId_test() throws RestClientException, URISyntaxException {
		ResponseEntity<TradeBook> response = restTemplate.getForEntity(new URI("http://localhost:" + port
				+ "/trade-book/trade-id/" + entity.getTradeId() + "/version/" + entity.getVersion()), TradeBook.class);
		when(service.getById(any(String.class), any(Integer.class))).thenReturn(entity);

		System.out.println(response.getBody());
		assertEquals(entity, response.getBody());
	}
	
	@Test
	public void addTrade_test() throws RestClientException, URISyntaxException {
		ResponseEntity<String> response = restTemplate.postForEntity(new URI("http://localhost:" + port + "/trade-book/add"), entity, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
}
