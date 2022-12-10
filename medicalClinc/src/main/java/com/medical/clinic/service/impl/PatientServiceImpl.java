package com.medical.clinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.clinic.domain.Patient;
import com.medical.clinic.enums.ClinicErrorEnum;
import com.medical.clinic.exception.ClinicException;
import com.medical.clinic.repository.PatientRepository;
import com.medical.clinic.service.PatientService;

import reactor.core.publisher.Mono;

@Service
public class PatientServiceImpl implements PatientService {

	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Mono<Patient> findByName(String name) {
		
		return patientRepository.findByName(name)
				.switchIfEmpty(Mono.error(new ClinicException(ClinicErrorEnum.PATIENT_NOT_FOUND)));
	}

}
