package com.medical.clinic.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("appointment_cancel_reason")
public class AppointmentCancelReasons {

	@Id
	private Long id;
	
	@Column("reason")
	private String reason;
	
	@Column("appointment_id")
	private Long appontment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getAppontment() {
		return appontment;
	}

	public void setAppontment(Long appontment) {
		this.appontment = appontment;
	}
}
