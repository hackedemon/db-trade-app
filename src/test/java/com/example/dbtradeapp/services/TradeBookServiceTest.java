package com.example.dbtradeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.entities.composite.TradeBookId;
import com.example.dbtradeapp.repos.TradeBookRepo;

@SpringBootTest
public class TradeBookServiceTest {

	@InjectMocks
	private TradeBookService service = new TradeBookServiceImpl();

	@Mock
	private TradeBookRepo repo;

	TradeBook entity;

	@BeforeEach
	public void setup() {
		entity = new TradeBook("T1", 1, "CP-1", "B1", LocalDate.parse("2021-05-20"), LocalDate.parse("2021-04-28"),
				false);
	}

	@Test
	public void getTradeBookById_test() {
		when(repo.findById(any(TradeBookId.class))).thenReturn(Optional.of(entity));

		TradeBook tradeBook = service.getById(entity.getTradeId(), entity.getVersion());
		assertEquals(entity, tradeBook);
	}

	@Test
	public void addTrade_test() {
		service.addTrade(entity);

		verify(repo, times(1)).save(entity);
	}

}
