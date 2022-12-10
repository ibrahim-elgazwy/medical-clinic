package com.medical.clinic.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.clinic.domain.Appointment;
import com.medical.clinic.dto.AppointmentCancelReasonDto;
import com.medical.clinic.dto.RestResponse;
import com.medical.clinic.service.AppointmentService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping(value="/todayAppointments", produces = MediaType.APPLICATION_JSON_VALUE) 
	public Mono<RestResponse> getAllTodayAppointments(){
		
		return appointmentService.getAllTodayAppointments()
				.collectList()
		        .map(RestResponse::new);
	}
	
	@GetMapping(value="/searchByPatientName/{patientName}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public Mono<RestResponse>  searchForAppointmentsByPatientName(
			@PathVariable("patientName") String patientName){

		return appointmentService.getAppointmentsByPatientName(patientName)
				.collectList()
		        .map(RestResponse::new);
	}
	
	@GetMapping(value="/searchByAppointMentDate", produces = MediaType.APPLICATION_JSON_VALUE) 
	public Mono<RestResponse> searchForAppointmentsByDate(
			@RequestParam(name = "appointmentDate", required = true) 
				@DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate){

		return appointmentService.getAppointmentsByDate(appointmentDate)
				.collectList()
		        .map(RestResponse::new);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<RestResponse> addNewAppointMent(@Valid @RequestBody Mono<Appointment> appointment) {
		
		return appointmentService.addNewAppointment(appointment)
		        .map(RestResponse::new);
	}
	
	@PutMapping(value="/cancelAppointment", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<RestResponse>  cancelAppointment(
			@RequestBody AppointmentCancelReasonDto appointmentCancelReason) {
		
		return appointmentService.cancelAppointment(appointmentCancelReason)
				.map(RestResponse::new);
	}
}
