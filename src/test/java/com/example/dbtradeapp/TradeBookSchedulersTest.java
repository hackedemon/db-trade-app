package com.example.dbtradeapp;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.schedulers.TradeBookSchedulers;
import com.example.dbtradeapp.services.TradeBookService;

@SpringBootTest
public class TradeBookSchedulersTest {
	
	@Mock
	private TradeBookService service;

	@Autowired
	private TradeBookSchedulers scheduler;
	
	@Test
	public void updateExpireFlag_test() {
		List<TradeBook> list = new ArrayList<>();
		list.add(new TradeBook("T1", 3, "CP-1", "B1", LocalDate.now().minusDays(45),
				LocalDate.parse("2021-04-30"), false));
		list.add(new TradeBook("T1", 3, "CP-1", "B1", LocalDate.now(),
				LocalDate.parse("2021-04-30"), false));
		list.add(new TradeBook("T1", 3, "CP-1", "B1", LocalDate.now().minusDays(1),
				LocalDate.parse("2021-04-30"), false));
		list.add(new TradeBook("T1", 3, "CP-1", "B1", LocalDate.now().plusDays(1),
				LocalDate.parse("2021-04-30"), false));
		when(service.getAllTradesLessThanMaturityDate(LocalDate.now())).thenReturn(list);
		
		scheduler.updateExpireFlag();
		verify(service, times(4));
	}
	
}
