package com.medical.clinic.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AppointmentCancelReasonDto {

	@NotNull(message = "apointmentId status id must be not null")
	@Min(value=1, message="apointmentId must be greater than zero") 
	private Long apointmentId;
	
	@NotNull(message = "cancel reason must be not null")
	private String reason;

	public Long getApointmentId() {
		return apointmentId;
	}

	public void setApointmentId(Long apointmentId) {
		this.apointmentId = apointmentId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
