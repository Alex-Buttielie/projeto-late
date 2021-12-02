package br.com.iateclubedebrasilia.api.services.exceptions;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidationException(String msg) {
		super(msg);
	}

	public ValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
