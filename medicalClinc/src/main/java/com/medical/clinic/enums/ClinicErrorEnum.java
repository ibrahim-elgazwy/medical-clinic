package com.medical.clinic.enums;

public enum ClinicErrorEnum {

	APPOINTMENT_NOT_FOUND("APPOINTMENT_NOT_FOUND", "Appointment Not Founded!"),
	INVALID_FIELDS("INVALID_FIELDS", "invalid body fields"),
	APPOINTMENT_STATUS_NOT_FOUND("APPOINTMENT_STATUS_NOT_FOUND", "invalid appointment status id"),
	PATIENT_NOT_FOUND("PATIENT_NOT_FOUND", "Patient Not Founded!");
	
	
	private String errorCode;
	private String errorDescription;
	
	private ClinicErrorEnum(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
}
