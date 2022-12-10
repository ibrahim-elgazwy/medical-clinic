package com.medical.clinic.dto;

import java.io.Serializable;
import java.util.List;

import com.medical.clinic.enums.StatusEnum;
import com.medical.clinic.exception.ErrorDetails;

public class RestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6409809055025344148L;

	private StatusEnum status;
	private String errorCode;
	private String errorDescription;
	private Object body;

	public RestResponse() {
		this.status = StatusEnum.OK;
	}

	public RestResponse(Object body) {
		this();
		this.body = body;
	}
	
	public RestResponse(String errorCode, String errorDescription) {
		this.status = StatusEnum.ERROR;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public RestResponse(StatusEnum statusEnum, List<String> errorDetails) {
		this.status = statusEnum;
		this.setBody(errorDetails);
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
