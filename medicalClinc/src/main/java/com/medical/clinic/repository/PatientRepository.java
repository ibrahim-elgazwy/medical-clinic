package com.medical.clinic.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.medical.clinic.domain.Patient;

import reactor.core.publisher.Flux;

@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {

	Flux<Patient> findByNameContainingIgnoreCase(String name);
}
