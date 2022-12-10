package com.medical.clinic.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = AppointmentDateConstraintValidator.class)
public @interface ValidAppointmentDate {

    String message() default "Appointment Date Not Valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
