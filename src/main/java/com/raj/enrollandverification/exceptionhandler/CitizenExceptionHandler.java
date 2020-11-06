package com.raj.enrollandverification.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.raj.enrollandverification.constants.AppConstants;
import com.raj.enrollandverification.response.SSNResponse;

@ControllerAdvice
public class CitizenExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<SSNResponse> exceptionHandler(CitizenNotFoundException exc) {
		
		SSNResponse res = new SSNResponse();

		res.setSsn("Null");
		res.setStatus(AppConstants.NO_SUCH_CITIZEN);
		
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
		
		
	}

}
