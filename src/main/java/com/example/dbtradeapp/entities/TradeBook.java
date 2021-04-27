package com.example.dbtradeapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.dbtradeapp.entities.composite.TradeBookId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trade_book")
@IdClass(TradeBookId.class)
public class TradeBook {

	@Id
	private String tradeId;
	
	@Id
	private int version;
	
	@Column
	private String counterPartyId;

	@Column
	private String bookId;

	@Column
	private Date maturityDate;

	@Column
	private Date createdDate;

	@Column
	private boolean expired;
	
}
