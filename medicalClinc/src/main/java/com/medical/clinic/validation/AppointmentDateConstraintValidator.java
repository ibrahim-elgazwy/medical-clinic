package com.medical.clinic.validation;

import static java.util.Objects.isNull;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.medical.clinic.domain.Appointment;

public class AppointmentDateConstraintValidator implements ConstraintValidator<ValidAppointmentDate, Appointment> {

	@Override
	public boolean isValid(Appointment appointment, ConstraintValidatorContext context) {
		
		if(isNull(appointment.getAppointmentDate()))
			return false;
		
		return !appointment.getAppointmentDate()
					.isBefore(LocalDate.now());
	}
	

}
