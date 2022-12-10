package com.medical.clinic.service;

import com.medical.clinic.domain.Patient;

import reactor.core.publisher.Mono;

public interface PatientService {
	
	Mono<Patient> findByName(String name);

}
