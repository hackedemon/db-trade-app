package com.example.dbtradeapp.error;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.dbtradeapp.exceptions.InvalidDataException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
    	List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
    	
    	return responseEntityCreator(errors, headers, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidDataException.class)
    public final ResponseEntity<Object> handleInvalidData(InvalidDataException ex, WebRequest request) {
    	List<String> errors = Arrays.asList(ex.getMessage());
		return responseEntityCreator(errors , new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

	/**
	 * @param ex
	 * @param headers
	 * @param status
	 * @return
	 */
	private ResponseEntity<Object> responseEntityCreator(List<String> errors, HttpHeaders headers,
			HttpStatus status) {
    	Map<String, Object> body = new LinkedHashMap<>();
    	body.put("timestamp", LocalDateTime.now());
    	body.put("status", status.value());
    	body.put("errors", errors);
    	
    	return new ResponseEntity<>(body, headers, status);
	}

}
