CREATE database covid_tracking;

USE covid_tracking;
DROP DATABASE covid_tracking;

CREATE TABLE confirmed(
confirmed_name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL,
id INT PRIMARY KEY UNIQUE NOT NULL,
AMKA INT NOT NULL,
area VARCHAR(20) NOT NULL,
street VARCHAR(50) NOT NULL,
street_number INT NOT NULL,
zip INT NOT NULL,
email VARCHAR(20),
active_status BOOLEAN NOT NULL);

 CREATE TABLE confirmed_phone(
 id INT UNIQUE NOT NULL,
 phone VARCHAR(20) NOT NULL,
 CONSTRAINT FK_id FOREIGN KEY (id) REFERENCES confirmed (id));
 
CREATE TABLE cured(
id INT UNIQUE NOT NULL,
cured_date DATE NOT NULL,
CONSTRAINT FK_cured_id FOREIGN KEY (id) REFERENCES confirmed (id));

CREATE TABLE deceased(
id INT UNIQUE NOT NULL,
deceased_date DATE NOT NULL,
CONSTRAINT FK_deceased_id FOREIGN KEY (id) REFERENCES confirmed (id));

CREATE TABLE victim_contacts(
surname VARCHAR(20) NOT NULL,
contact_id INT PRIMARY KEY UNIQUE NOT NULL,
confirmed_id INT,
AMKA INT NOT NULL,
area VARCHAR(20) NOT NULL,
street VARCHAR(50) NOT NULL,
street_number INT NOT NULL,
zip INT NOT NULL,
email VARCHAR(50),
victim_relationship VARCHAR(20) NOT NULL,
FOREIGN KEY (confirmed_id) REFERENCES confirmed (id));

CREATE TABLE contact_phone(
 id INT UNIQUE NOT NULL,
 phone VARCHAR(20) NOT NULL,
 CONSTRAINT FK_contact_id FOREIGN KEY (id) REFERENCES victim_contacts (contact_id));
 
 CREATE TABLE high_danger(
 id INT UNIQUE NOT NULL,
 FOREIGN KEY (id) REFERENCES victim_contacts (contact_id));
 
 CREATE TABLE low_danger(
 id INT UNIQUE NOT NULL,
 FOREIGN KEY (id) REFERENCES victim_contacts (contact_id));
 
 
 



 





