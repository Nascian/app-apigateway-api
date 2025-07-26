package com.tcc.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericErrorDTO {
    public Date timestamp;
    public int status;
    public String error;
    public String path;
}


