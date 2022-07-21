package farheen.foundation.bank.commons;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvise {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFoundException(Exception e){
		
		CustomErrorResponse customErrorResponse = new CustomErrorResponse("NOT_FOUND_EXCEPTION", e.getMessage());
		
		customErrorResponse.setTimeStamp(LocalDateTime.now());
		customErrorResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse, HttpStatus.NOT_FOUND);
		
	}

}
