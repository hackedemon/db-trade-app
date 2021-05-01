package com.example.dbtradeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DbTradeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbTradeAppApplication.class, args);
	}

}
