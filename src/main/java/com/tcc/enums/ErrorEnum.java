package com.tcc.enums;

public enum ErrorEnum {
    TECHNICAL("001","Ocurrio un error inesperado"),
	
	BUSINESS("002","Error de negoci"),
	DOCUMENT("003","No se cuenta con tipo o numero de documento dentro de la estructura recibida"),
	ORIGIN("004","Origen desconocido o dentro de las excepciones a procesar"),
	EXCEPTION("005","Se genera una excepcion durante el proceso"),
	INFORMATION("006","Se genera un error en la construccion del request de candidatos"),
	DATABASIC("007","Se genera un error con la informacion basica a procesar"),
	CONFIG("008","No se logran recuperar las configariones requeridas"),
    ;
	
	private String code;
	private String description;
	
	private ErrorEnum(String code, String description) {
		this.code=code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	
	
}

