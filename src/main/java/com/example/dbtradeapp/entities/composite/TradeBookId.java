package com.example.dbtradeapp.entities.composite;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TradeBookId implements Serializable {

	private static final long serialVersionUID = -4248286830567228185L;

	private String tradeId;
	
	private int version;
	
}
