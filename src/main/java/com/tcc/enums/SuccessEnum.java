	package com.tcc.enums;

public enum SuccessEnum {
	SUCCESS("200", "Consulta realizada exitosamente"),
	NOTDATA("202", "Consulta realizada exitosamente, sin daatos de respuesta"), CREATE("201", "Registro Exitoso"),
	NOTCREATE("204", "Se ha presentado error en el registro registro");

	private String code;
	private String description;

	private SuccessEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
