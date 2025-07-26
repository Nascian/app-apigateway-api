package com.tcc.exceptions;

import org.springframework.http.HttpStatus;

import com.tcc.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiException extends RuntimeException{

	 private ErrorEnum error;
      private HttpStatus status;
     private String message;


}

