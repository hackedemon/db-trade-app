package com.example.dbtradeapp.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TradeBookPostDTO {

	@NotBlank(message = "{tradeId.notBlank}")
	private String tradeId;

	@Min(value = 1, message = "{version.min}")
	private int version;

	@NotBlank(message = "{counterPartyId.notBlank}")
	private String counterPartyId;

	@NotBlank(message = "{bookId.notEmpty}")
	private String bookId;

	@NotNull(message = "{maturityDate.notEmpty}")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate maturityDate;

}
