package com.example.dbtradeapp.schedulers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.dbtradeapp.services.TradeBookService;

@Component
public class TradeBookSchedulers {

	@Autowired
	private TradeBookService service;

	/**
	 * Scheduler which runs at 00:00 daily to update expire flag for all values
	 * having maturity date less than today's date.
	 */
	@Scheduled(cron = "${scheduler.updateExpireFlag}")
	public void updateExpireFlag() {
		service.getAllTradesLessThanMaturityDate(LocalDate.now()).forEach(trade -> {
			trade.setExpired(true);
			service.updateTrade(trade);
		});
	}

}
