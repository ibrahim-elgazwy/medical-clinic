package com.medical.clinic.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.medical.clinic.validation.ValidAppointmentDate;

@ValidAppointmentDate
public class AppointmentDto {

	@NotNull(message = "appointmentDate date must be not null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;

	@NotNull(message = "patient id must be not null")
	@Min(value=1, message="patient id must be greater than zero")  
	private Long patient;

	@NotNull(message = "appointment status id must be not null")
	@Min(value=1, message="status id must be greater than zero") 
	private Long status;

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Long getPatient() {
		return patient;
	}

	public void setPatient(Long patient) {
		this.patient = patient;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
}
