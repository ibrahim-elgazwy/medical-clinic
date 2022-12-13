insert into patient(id, name, email, mobile) values(1,'ahmed ali','user1@gmail.com','01234569845');
insert into patient(id, name, email, mobile) values(2, 'john doe','user2@gmail.com','01234569888');
insert into patient(id, name, email, mobile) values(3, 'ibrahim elrouby','user3@gmail.com','01234569849');

insert into appointment_status(id, status) values(1,'REGISTER');
insert into appointment_status(id, status) values(2, 'CANCEL');
insert into appointment_status(id, status) values(3, 'ATTENDED');
insert into appointment_status(id, status) values(4, 'RE_ATTENDED');


insert into appointment(appointment_date, patient_id, status_id)  values('2022-12-14', 1, 2);

insert into appointment(appointment_date, patient_id, status_id)  values('2022-12-14', 1, 1);

insert into appointment(appointment_date, patient_id, status_id)  values('2022-12-15', 2, 1);

insert into appointment(appointment_date, patient_id, status_id)  values('2022-12-15', 2, 3);

insert into appointment(appointment_date, patient_id, status_id)  values('2022-11-20', 2, 4);

insert into appointment(appointment_date, patient_id, status_id)  values('2022-12-18', 3, 1);

insert into appointment(appointment_date, patient_id, status_id)  values('2022-12-16', 3, 1);
insert into appointment(appointment_date, patient_id, status_id)  values('2022-12-16', 1, 1);


insert into appointment_cancel_reason(reason, appointment_id)  values('I visit another doctor', 1);

