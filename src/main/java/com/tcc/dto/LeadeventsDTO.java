package com.tcc.dto;

import java.io.Serializable;

import com.tcc.enums.EStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeadeventsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private EStatus status;
	private String payload;
	private long count;
	private String statusMessage;
	private String eventName;
	private String source;
	private String business;

}
