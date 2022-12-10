package com.medical.clinic.dto;

public class AppointmentCancelReasonDto {

	private Long apointmentId;
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
