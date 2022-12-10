package com.medical.clinic.service;

import com.medical.clinic.domain.AppointmentCancelReasons;

import reactor.core.publisher.Mono;

public interface CancelAppointmentService {

	Mono<AppointmentCancelReasons> cancelAppointment(Long apointmentId, String reason);
}
