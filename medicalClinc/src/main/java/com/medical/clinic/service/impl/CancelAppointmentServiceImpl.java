package com.medical.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.clinic.domain.Appointment;
import com.medical.clinic.domain.AppointmentCancelReasons;
import com.medical.clinic.repository.AppointmentCancelReasonRepository;
import com.medical.clinic.service.CancelAppointmentService;

import reactor.core.publisher.Mono;

@Service
public class CancelAppointmentServiceImpl implements CancelAppointmentService {
	
	@Autowired
	private AppointmentCancelReasonRepository appointmentCancelReasonRepository;

	@Override
	public Mono<AppointmentCancelReasons> cancelAppointment(Long appointmetId, String reason) {
		
		AppointmentCancelReasons appointmentCancelReasons = new AppointmentCancelReasons();
		appointmentCancelReasons.setAppontment(appointmetId);
		appointmentCancelReasons.setReason(reason);
		
		return appointmentCancelReasonRepository.save(appointmentCancelReasons);
	}


}
