-- CREATE database covid_tracking;
-- DROP DATABASE covid_tracking;
USE covid_tracking;
/*
DROP TABLE Person;
DROP TABLE low_danger;
DROP TABLE high_danger;
DROP TABLE contact_phone;
DROP TABLE victim_contacts;
DROP TABLE deceased;
DROP TABLE cured;
DROP TABLE confirmed_phone;
DROP TABLE confirmed;
*/
CREATE TABLE Person (
	id INT PRIMARY KEY,
	name VARCHAR(20)
);

CREATE TABLE confirmed(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	surname VARCHAR(20) NOT NULL,
	AMKA VARCHAR(9) UNIQUE,
	area VARCHAR(20) NOT NULL,
	street VARCHAR(50) NOT NULL,
	street_number INT NOT NULL,
	zip INT NOT NULL,
	email VARCHAR(20),
	active_status BOOLEAN NOT NULL
);

 CREATE TABLE confirmed_phone(
	id INT PRIMARY KEY,
	phone VARCHAR(20) NOT NULL,
	CONSTRAINT FK_confirmed_phone_id FOREIGN KEY (id) REFERENCES confirmed (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);
 
CREATE TABLE cured(
	id INT PRIMARY KEY,
	cured_date DATE NOT NULL,
	CONSTRAINT FK_cured_id FOREIGN KEY (id) REFERENCES confirmed (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
 );

CREATE TABLE deceased(
	id INT PRIMARY KEY,
	deceased_date DATE NOT NULL,
	CONSTRAINT FK_deceased_id FOREIGN KEY (id) REFERENCES confirmed (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE victim_contacts(
	contact_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(20) NOT NULL,
	confirmed_id INT NOT NULL,
	AMKA INT NOT NULL, -- Το πιο πιθανό είναι να μην το ξέρει
	email VARCHAR(50),
	victim_relationship VARCHAR(20) NOT NULL,
	CONSTRAINT FK_victim_contacts_confirmed_id FOREIGN KEY (confirmed_id) REFERENCES confirmed (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE contact_phone(
	id INT PRIMARY KEY,
	phone VARCHAR(20) NOT NULL,
	CONSTRAINT FK_contact_phone_id FOREIGN KEY (id) REFERENCES victim_contacts (contact_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);
 
CREATE TABLE high_danger(
	id INT PRIMARY KEY,
	CONSTRAINT FK_high_danger_id FOREIGN KEY (id) REFERENCES victim_contacts (contact_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);
 
CREATE TABLE low_danger(
	id INT PRIMARY KEY,
	CONSTRAINT FK_low_danger_id FOREIGN KEY (id) REFERENCES victim_contacts (contact_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);