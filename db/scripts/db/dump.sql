
DROP TABLE IF EXISTS appointment_cancel_reason;
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS appointment_status;

create table patient(
	id bigserial PRIMARY KEY, 
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100),
	mobile VARCHAR(50) NOT NULL
);


create table appointment_status(
	id bigserial PRIMARY KEY, 
	status VARCHAR(100) NOT NULL
);


create table appointment(
	id bigserial, 
	appointment_date date,
	patient_id INT NOT NULL,
	status_id INT NOT NULL,
	FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE NO ACTION,
	FOREIGN KEY (status_id) REFERENCES appointment_status(id) ON DELETE NO ACTION
);

create table appointment_cancel_reason(
	id bigserial PRIMARY KEY, 
	appointment_id INT NOT NULL,
	reason VARCHAR(255) NOT NULL
);

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

