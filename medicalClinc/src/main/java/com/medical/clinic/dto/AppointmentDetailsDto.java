package com.medical.clinic.dto;

import java.time.LocalDate;

import com.medical.clinic.domain.AppointmentStatus;
import com.medical.clinic.domain.Patient;

public class AppointmentDetailsDto {

	private Long id;
	
	private LocalDate appointmentDate;
	
	private Patient patient;
	
	private AppointmentStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
}
