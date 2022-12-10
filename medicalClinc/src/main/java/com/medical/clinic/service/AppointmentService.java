package com.medical.clinic.service;

import java.util.Date;

import com.medical.clinic.domain.Appointment;
import com.medical.clinic.domain.AppointmentCancelReasons;
import com.medical.clinic.dto.AppointmentCancelReasonDto;
import com.medical.clinic.dto.AppointmentDetailsDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentService {

	Flux<AppointmentDetailsDto> getAllTodayAppointments();
	
	Mono<Appointment> addNewAppointment(Mono<Appointment> appointmentDto);
	
	Flux<AppointmentDetailsDto> getAppointmentsByDate(Date date);
	
	Flux<AppointmentDetailsDto> getAppointmentsByPatientName(String name);

	Mono<AppointmentCancelReasons> cancelAppointment(AppointmentCancelReasonDto appointmentCancelReason);
}
