package com.example.dbtradeapp.entities.composite;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TradeBookIdTest {
	
	TradeBookId tradeBookId;

	@Test
	public void testNoArgConstructor() {
		assertNotNull(new TradeBookId());
	}
	
	@Test
	public void testAllArgsConstructor() {
		assertNotNull(new TradeBookId("T2", 3));
	}
	
}
