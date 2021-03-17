package com.lti.studentservice.exception;

@SuppressWarnings("serial")
public class StudentException extends RuntimeException {

	public StudentException() {
		super();
	}

	public StudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StudentException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentException(Throwable cause) {
		super(cause);
	}

}
