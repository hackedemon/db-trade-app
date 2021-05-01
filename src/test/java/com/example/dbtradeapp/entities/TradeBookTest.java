package com.example.dbtradeapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TradeBookTest {

	TradeBook entity;

	@BeforeEach
	public void setup() {
		entity = new TradeBook("T1", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"), LocalDate.parse("2021-04-28"),
				false);
	}

	@Test
	public void testNoArgConstructor() {
		assertNotNull(new TradeBook());
	}

	@Test
	public void testTradeIdGettersSetters() {
		String tradeId = "T2";
		entity.setTradeId(tradeId);

		assertEquals(tradeId, entity.getTradeId());
	}

	@Test
	public void testVersionGettersSetters() {
		int version = 2;
		entity.setVersion(version);

		assertEquals(version, entity.getVersion());
	}

	@Test
	public void testCounterPartyIdGettersSetters() {
		String counterPartyId = "CP-9";
		entity.setCounterPartyId(counterPartyId);

		assertEquals(counterPartyId, entity.getCounterPartyId());
	}

	@Test
	public void testBookIdGettersSetters() {
		String bookId = "B3";
		entity.setBookId(bookId);

		assertEquals(bookId, entity.getBookId());
	}

	@Test
	public void testMaturityDateGettersSetters() {
		LocalDate date = LocalDate.now();
		entity.setMaturityDate(date);

		assertEquals(date, entity.getMaturityDate());
	}

	@Test
	public void testCreatedDateGettersSetters() {
		LocalDate date = LocalDate.now();
		entity.setCreatedDate(date);

		assertEquals(date, entity.getCreatedDate());
	}

	@Test
	public void testExpiredGettersSetters() {
		entity.setExpired(true);

		assertTrue(entity.isExpired());
	}

	@Test
	public void testEquals() {
		assertTrue(entity.equals(new TradeBook("T1", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"),
				LocalDate.parse("2021-04-28"), false)));
	}

	@Test
	public void testEquals_negative() {
		assertFalse(entity.equals(new TradeBook("T2", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"),
				LocalDate.parse("2021-04-28"), false)));
	}

	@Test
	public void testHashCode() {
		assertEquals(entity.hashCode(), new TradeBook("T1", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"),
				LocalDate.parse("2021-04-28"), false).hashCode());
	}

	@Test
	public void testHashCode_negative() {
		assertNotEquals(entity.hashCode(), new TradeBook("T2", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"),
				LocalDate.parse("2021-04-28"), false).hashCode());
	}

}
