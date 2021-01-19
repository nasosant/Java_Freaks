-- CREATE database covid_tracking;
-- DROP DATABASE covid_tracking;
USE covid_tracking;

DROP TABLE victim_contacts;
DROP TABLE deceased;
DROP TABLE cured;
DROP TABLE confirmed;

CREATE TABLE confirmed(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	email VARCHAR(50),
	AMKA INT UNIQUE,
    phonenumber INT NOT NULL,
	area VARCHAR(50) NOT NULL,
	street VARCHAR(50) NOT NULL,
	street_number INT NOT NULL,
	zip INT NOT NULL,
	active_status BOOLEAN NOT NULL
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
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
    email VARCHAR(50),
	AMKA INT UNIQUE,
    phonenumber INT NOT NULL,
	confirmed_id INT NOT NULL,
	victim_relationship VARCHAR(50) NOT NULL,
    danger VARCHAR(4) NOT NULL,
	CONSTRAINT FK_victim_contacts_confirmed_id FOREIGN KEY (confirmed_id) REFERENCES confirmed (id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);
