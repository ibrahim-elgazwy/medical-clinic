
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
	id bigserial PRIMARY KEY, 
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

