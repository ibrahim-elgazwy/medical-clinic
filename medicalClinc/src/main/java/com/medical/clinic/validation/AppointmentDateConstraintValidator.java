package com.medical.clinic.validation;

import static java.util.Objects.isNull;

import java.time.LocalDate;

import com.medical.clinic.domain.Appointment;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AppointmentDateConstraintValidator implements ConstraintValidator<ValidAppointmentDate, Appointment> {

	@Override
	public boolean isValid(Appointment appointment, ConstraintValidatorContext context) {
		
		if(isNull(appointment.getAppointmentDate()))
			return false;
		
		return !appointment.getAppointmentDate()
					.isBefore(LocalDate.now());
	}
	

}
