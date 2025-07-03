package com.management.app.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


	//	@ExceptionHandler({UserAlreadyExistException.class})
	//	public String userAlreadyExistExceptionHandler(Exception ex) {
	//		return ex.getMessage();
	//	}
	
	@ExceptionHandler({OldPasswordNotMatchedException.class})
	public ResponseEntity<String> OldPasswordNotMatchedException(Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({VerificationFailedException.class})
	public ResponseEntity<String> VerificationFailedException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({VerificationAlreadyDoneException.class})
	public ResponseEntity<String> VerificationAlreadyDoneException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({UserAlreadyExistException.class})
	public ResponseEntity<String> userAlreadyExistExceptionHandler(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({UserNotFoundException.class})
	public  ResponseEntity<String> userNotFoundExceptionHandler(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}


//	@ExceptionHandler({Exception.class})
//	public  ResponseEntity<String> EcxeptionHandler(Exception ex) {
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
