package com.medical.clinic.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.medical.clinic.dto.RestResponse;
import com.medical.clinic.enums.StatusEnum;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RestResponse handleWebExchangeBindException(WebExchangeBindException e) {
        
    	var errors = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    	
        return new RestResponse(StatusEnum.ERROR, errors);
    }
    
	@ExceptionHandler(ClinicException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse handleClinicException(ClinicException clinicException) {
	
		return new RestResponse(clinicException.getErrorCode(), 
				clinicException.getErrorDescription());
	}
}
