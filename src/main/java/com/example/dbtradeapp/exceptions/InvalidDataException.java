package com.example.dbtradeapp.exceptions;

public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = -313331246183496781L;
	
	public InvalidDataException(String message) {
		super(message);
	}

}
