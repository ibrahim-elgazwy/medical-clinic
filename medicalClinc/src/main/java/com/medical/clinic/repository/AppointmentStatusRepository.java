package com.medical.clinic.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.medical.clinic.domain.AppointmentStatus;

@Repository
public interface AppointmentStatusRepository extends ReactiveCrudRepository<AppointmentStatus, Long> {

}
