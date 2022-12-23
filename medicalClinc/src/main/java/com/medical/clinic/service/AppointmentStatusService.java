package com.medical.clinic.service;

import com.medical.clinic.domain.AppointmentStatus;

import reactor.core.publisher.Mono;

public interface AppointmentStatusService {

	Mono<AppointmentStatus> findAppointmentStatusById(Long id);
}
