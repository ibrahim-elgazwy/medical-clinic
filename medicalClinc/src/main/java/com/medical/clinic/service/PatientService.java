package com.medical.clinic.service;

import com.medical.clinic.domain.Patient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientService {
	
	Flux<Patient> findByName(String name);

	Mono<Patient> findById(Long id);

}
