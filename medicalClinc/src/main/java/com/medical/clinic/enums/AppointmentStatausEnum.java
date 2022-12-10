package com.medical.clinic.enums;

public enum AppointmentStatausEnum {

	REGISTER(1l), 
	CANCEL(2l), 
	ATTENDED(3l), 
	RE_ATTENDED(4l);

	private Long id;

	private AppointmentStatausEnum(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
