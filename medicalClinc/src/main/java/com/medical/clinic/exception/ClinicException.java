package com.medical.clinic.exception;

import java.io.Serializable;

import com.medical.clinic.enums.ClinicErrorEnum;

public class ClinicException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9104774395299694560L;

	private String errorCode;
	private String errorDescription;
	private Long requestId;
	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public ClinicException(ClinicErrorEnum clinicErrorEnum) {
		this.errorCode = clinicErrorEnum.getErrorCode();
		this.errorDescription = clinicErrorEnum.getErrorDescription();
	}
	
	public ClinicException(ClinicErrorEnum clinicErrorEnum, Long requestId) {
		this(clinicErrorEnum);
		this.requestId = requestId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
