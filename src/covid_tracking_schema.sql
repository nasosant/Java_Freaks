CREATE database covid_tracking;

USE covid_tracking;
DROP DATABASE covid_tracking;

/* ΚΛΑΣΗ ΜΕ ΤΑ ΚΟΙΝΑ ΣΤΟΙΧΕΙΑ ΤΩΝ confirmed ΚΑΙ victim_contacts ΟΙ ΟΠΟΙΕΣ ΤΩΝ ΚΑΝΟΥΝ EXTEND

CREATE TABLE AllPeople (
	id int PRIMARY KEY auto_increment,
	surname VARCHAR(20) NOT NULL,
	AMKA INT NOT NULL,
	area VARCHAR(20) NOT NULL,
	street VARCHAR(50) NOT NULL,
	street_number INT NOT NULL,
	zip INT NOT NULL,
	email VARCHAR(20)
);
*/

CREATE TABLE confirmed(
	confirmed_name VARCHAR(20) NOT NULL,  -- ΜΗΠΩΣ ΔΕΝ ΧΡΕΙΑΖΕΤΑΙ??
	surname VARCHAR(20) NOT NULL,
	id INT PRIMARY KEY AUTO_INCREMENT,
	AMKA INT NOT NULL,
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
);
 
CREATE TABLE cured(
	id INT PRIMARY KEY,
	cured_date DATE NOT NULL,
	CONSTRAINT FK_cured_id FOREIGN KEY (id) REFERENCES confirmed (id)
 );

CREATE TABLE deceased(
	id INT PRIMARY KEY,
	deceased_date DATE NOT NULL,
	CONSTRAINT FK_deceased_id FOREIGN KEY (id) REFERENCES confirmed (id)
);

CREATE TABLE victim_contacts(
	surname VARCHAR(20) NOT NULL,
	contact_id INT PRIMARY KEY AUTO_INCREMENT,
	confirmed_id INT,      -- ΜΗΠΩΣ ΘΕΛΕΙ NOT NULL
	AMKA INT NOT NULL,
	area VARCHAR(20) NOT NULL,
	street VARCHAR(50) NOT NULL,
	street_number INT NOT NULL,
	zip INT NOT NULL,
	email VARCHAR(50),
	victim_relationship VARCHAR(20) NOT NULL,
	CONSTRAINT FK_victim_contacts_confirmed_id FOREIGN KEY (confirmed_id) REFERENCES confirmed (id)
);

CREATE TABLE contact_phone(
	id INT PRIMARY KEY,
	phone VARCHAR(20) NOT NULL,
	CONSTRAINT FK_contact_phone_id FOREIGN KEY (id) REFERENCES victim_contacts (contact_id)
);
 
 CREATE TABLE high_danger(
	id INT PRIMARY KEY,
	CONSTRAINT FK_high_danger_id FOREIGN KEY (id) REFERENCES victim_contacts (contact_id)
);
 
 CREATE TABLE low_danger(
	id INT PRIMARY KEY,
	CONSTRAINT FK_low_danger_id FOREIGN KEY (id) REFERENCES victim_contacts (contact_id)
 );
