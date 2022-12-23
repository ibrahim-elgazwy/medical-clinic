package com.medical.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.clinic.domain.AppointmentStatus;
import com.medical.clinic.enums.ClinicErrorEnum;
import com.medical.clinic.exception.ClinicException;
import com.medical.clinic.repository.AppointmentStatusRepository;
import com.medical.clinic.service.AppointmentStatusService;

import reactor.core.publisher.Mono;

@Service
public class AppointmentStatusServiceImpl implements AppointmentStatusService {

	@Autowired
	private AppointmentStatusRepository appointmentStatusRepository;
	
	@Override
	public Mono<AppointmentStatus> findAppointmentStatusById(Long id) {

		return appointmentStatusRepository.findById(id)
				.switchIfEmpty(Mono.error(
						new ClinicException(ClinicErrorEnum.APPOINTMENT_STATUS_NOT_FOUND)))
				.map(status -> status);
	}

}
