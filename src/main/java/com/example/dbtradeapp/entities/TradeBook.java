package com.example.dbtradeapp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.dbtradeapp.entities.composite.TradeBookId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
	private LocalDate maturityDate;

	@Column
	private LocalDate createdDate;

	@Column
	private boolean expired;

}
