package com.medical.clinic.repository;

import java.util.Date;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.medical.clinic.domain.Appointment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AppointmentRepository extends ReactiveCrudRepository<Appointment, Long> {

	Flux<Appointment> findByAppointmentDate(Date date);
	
	Flux<Appointment> findByPatient(Long id);
	
	@Modifying
	@Query("UPDATE Appointment app SET app.status = $1 WHERE app.id = $2")
	Mono<Appointment> updateAppointMentStatus(Long status, Long appointmentId);
}
