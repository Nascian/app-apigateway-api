package com.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultDTO {

	@JsonProperty("codigo")
	private String code;
	@JsonProperty("descripcion")
	private String description;
	@JsonProperty("mensaje")
	private String message;

}