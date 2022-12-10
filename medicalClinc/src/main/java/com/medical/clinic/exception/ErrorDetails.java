package com.medical.clinic.exception;

public class ErrorDetails {

	private String field;
	private String message;

	public ErrorDetails(String field, String message) {
		super();
		this.message = message;
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
