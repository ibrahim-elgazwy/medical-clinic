package com.medical.clinic.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.medical.clinic.domain.AppointmentCancelReasons;

@Repository
public interface AppointmentCancelReasonRepository extends ReactiveCrudRepository<AppointmentCancelReasons, Long> {

}
