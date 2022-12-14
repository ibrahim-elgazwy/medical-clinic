package com.medical.clinic.service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.clinic.domain.Appointment;
import com.medical.clinic.domain.AppointmentCancelReasons;
import com.medical.clinic.domain.Patient;
import com.medical.clinic.dto.AppointmentCancelReasonDto;
import com.medical.clinic.dto.AppointmentDetailsDto;
import com.medical.clinic.dto.AppointmentDto;
import com.medical.clinic.enums.AppointmentStatausEnum;
import com.medical.clinic.enums.ClinicErrorEnum;
import com.medical.clinic.exception.ClinicException;
import com.medical.clinic.repository.AppointmentRepository;
import com.medical.clinic.service.AppointmentService;
import com.medical.clinic.service.AppointmentStatusService;
import com.medical.clinic.service.CancelAppointmentService;
import com.medical.clinic.service.PatientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private CancelAppointmentService cancelAppointmentService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AppointmentStatusService AppointmentStatusService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public Mono<Appointment> addNewAppointment(Mono<AppointmentDto> appointmentDto) {
				
		return appointmentDto
				.flatMap(this::validateAppointment)
				.map(appointment -> modelMapper.map(appointment, Appointment.class))
				.flatMap(appointmentRepository::save);
	}
	
	private Mono<AppointmentDto> validateAppointment(AppointmentDto appointmentDto) {
		
		return Mono.zip(patientService.findById(appointmentDto.getPatient()), 
				AppointmentStatusService.findAppointmentStatusById(appointmentDto.getStatus()))
			.map(res -> appointmentDto);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Mono<AppointmentCancelReasons> cancelAppointment(AppointmentCancelReasonDto appointmentCancelReason) {

		return appointmentRepository.findById(appointmentCancelReason.getApointmentId())
			.switchIfEmpty(Mono.error(new ClinicException(ClinicErrorEnum.APPOINTMENT_NOT_FOUND)))
			.flatMap(appointment -> {
				appointment.setStatus(AppointmentStatausEnum.CANCEL.getId());
				return updateAppointMentCancelStatus(appointment, appointmentCancelReason);
			});
			
	}
	
	private Mono<AppointmentCancelReasons> updateAppointMentCancelStatus(
			Appointment appointment, AppointmentCancelReasonDto appointmentCancelReason) {
		
		return Mono.zip(appointmentRepository.save(appointment), 
				
					cancelAppointmentService.cancelAppointment(appointmentCancelReason.getApointmentId(), 
							appointmentCancelReason.getReason()))
				
				.map(Tuple2::getT2);
	}
	
	@Override
	public Flux<AppointmentDetailsDto> getAllTodayAppointments() {

		return appointmentRepository.findByAppointmentDate(new Date())
				.flatMap(this::getAppointMentDetails);
	}

	@Override
	public Flux<AppointmentDetailsDto> getAppointmentsByDate(Date date) {
		
		return appointmentRepository.findByAppointmentDate(date)
				.flatMap(this::getAppointMentDetails);
	}

	@Override
	public Flux<AppointmentDetailsDto> getAppointmentsByPatientName(String name) {
		
		return patientService.findByName(name)
				.flatMap(this::findAppointMentByPatient);
	}
	
	private Flux<AppointmentDetailsDto> findAppointMentByPatient(Patient patient) {
		
		return appointmentRepository.findByPatient(patient.getId())
				.switchIfEmpty(Mono.error(new ClinicException(ClinicErrorEnum.APPOINTMENT_NOT_FOUND)))
				.flatMap(this::getAppointMentDetails);
	}
	
	private Flux<AppointmentDetailsDto> getAppointMentDetails(Appointment appointment) {
		
		return Flux.zip(
				patientService.findById(appointment.getPatient()), 
				AppointmentStatusService.findAppointmentStatusById(appointment.getStatus())
		).map(res -> {
			
			AppointmentDetailsDto dto = new AppointmentDetailsDto();
			dto.setId(appointment.getId());
			dto.setAppointmentDate(appointment.getAppointmentDate());
			dto.setPatient(res.getT1());
			dto.setStatus(res.getT2());
			
			return dto;
		});
	}
}
