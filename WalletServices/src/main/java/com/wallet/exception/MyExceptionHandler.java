package com.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
	
	/*for all type of exceptions need to modify the class name
	 * @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	 * handleAllExceptions(Exception ex, WebRequest request) { ExceptionResponse
	 * exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	 * request.getDescription(false)); return new ResponseEntity(exceptionResponse,
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	
	
	@ExceptionHandler(value = { AccountException.class })
	public ResponseEntity<?> handleAccountException(AccountException ex, WebRequest request) {
		String message = ex.getLocalizedMessage();
		

		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	@ExceptionHandler(value = { AccountNotFound.class })
	public ResponseEntity<?> handleAccountException(AccountNotFound ex, WebRequest request) {
		String message = ex.getLocalizedMessage();
		

		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);

	}
	
	

}
