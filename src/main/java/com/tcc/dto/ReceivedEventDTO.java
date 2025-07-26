package com.tcc.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReceivedEventDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HeadersDTO headers;
	private String payload;

	@lombok.Data
	@ToString
	public class HeadersDTO implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String source;
		private String business;
		private String eventName;
	}

}
