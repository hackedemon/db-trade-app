package com.example.dbtradeapp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.dbtradeapp.entities.composite.TradeBookId;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "trade_book")
@IdClass(TradeBookId.class)
public class TradeBook {

	@Id
	@NotBlank(message = "{tradeId.notBlank}")
	private String tradeId;

	@Id
	@Min(value = 1, message = "{version.min}")
	private int version;

	@Column
	@NotBlank(message = "{counterPartyId.notBlank}")
	private String counterPartyId;

	@Column
	@NotBlank(message = "{bookId.notEmpty}")
	private String bookId;

	@NotNull(message = "{maturityDate.notEmpty}")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column
	private LocalDate maturityDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column
	private LocalDate createdDate;

	@Column
	private boolean expired;

}
