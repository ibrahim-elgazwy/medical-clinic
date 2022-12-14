package com.medical.clinic.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.clinic.dto.AppointmentCancelReasonDto;
import com.medical.clinic.dto.AppointmentDto;
import com.medical.clinic.dto.RestResponse;
import com.medical.clinic.service.AppointmentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/todayAppointments") 
	public Mono<RestResponse> getAllTodayAppointments(){
		
		return appointmentService.getAllTodayAppointments()
				.collectList()
		        .map(RestResponse::new);
	}
	
	@GetMapping("/searchByPatientName/{patientName}") 
	public Mono<RestResponse>  searchForAppointmentsByPatientName(
			@PathVariable("patientName") String patientName){

		return appointmentService.getAppointmentsByPatientName(patientName)
				.collectList()
		        .map(RestResponse::new);
	}
	
	@GetMapping("/searchByAppointMentDate") 
	public Mono<RestResponse> searchForAppointmentsByDate(
			@RequestParam(name = "appointmentDate", required = true) 
				@DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate){

		return appointmentService.getAppointmentsByDate(appointmentDate)
				.collectList()
		        .map(RestResponse::new);
	}
	
	@PostMapping
	public Mono<RestResponse> addNewAppointMent(@Valid @RequestBody Mono<AppointmentDto> appointment) {
		
		return appointmentService.addNewAppointment(appointment)
		        .map(RestResponse::new);
	}
	
	@PutMapping("/cancelAppointment")
	public Mono<RestResponse>  cancelAppointment(
			@Valid @RequestBody AppointmentCancelReasonDto appointmentCancelReason) {
		
		return appointmentService.cancelAppointment(appointmentCancelReason)
				.map(RestResponse::new);
	}
}
