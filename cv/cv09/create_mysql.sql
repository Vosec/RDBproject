Create table TEACHERS
(
	id_teacher Integer  NOT NULL AUTO_INCREMENT,
	id_office Integer NOT NULL,
	name varchar(30) NOT NULL,
	surname varchar(30) NOT NULL,
	title_before varchar(10) NULL,
	title_after varchar(10) NULL,
	email varchar(30) NOT NULL, UNIQUE (email),
	is_admin Binary(1) NOT NULL,
Primary Key (id_teacher)
); 

Create table OFFICES
(
	id_office Integer  NOT NULL AUTO_INCREMENT,
	name varchar(30) NOT NULL, UNIQUE (name),
	abb varchar(5) NULL, UNIQUE (abb),
	is_external Binary(1) NOT NULL,
Primary Key (id_office)
);

Create table STUDENTS
(
	id_student Integer  NOT NULL AUTO_INCREMENT,
	id_program Integer NOT NULL,
	name varchar(30) NOT NULL,
	surname varchar(30) NOT NULL,
	title_before varchar(10) NULL,
	title_after varchar(10) NULL,
	email varchar(30) NOT NULL, UNIQUE (email),
	personal_number varchar(10) NULL,
Primary Key (id_student)
); 

Create table TOPICS
(
	id_topic Integer  NOT NULL AUTO_INCREMENT,
	id_teacher Integer NOT NULL,
	id_student Integer NULL,
	title varchar(50) NOT NULL,
	abstract varchar(500) NOT NULL,
	year Datetime NOT NULL,
Primary Key (id_topic)
); 

Create table REQUESTS
(
	id_student Integer NOT NULL,
	id_topic Integer NOT NULL,
Primary Key (id_student,id_topic)
); 

Create table PROGRAMS
(
	id_program Integer  NOT NULL AUTO_INCREMENT,
	id_parent Integer NOT NULL,
	name varchar(30) NOT NULL,
	abb varchar(5) NOT NULL, UNIQUE (abb),
Primary Key (id_program)
); 

Create table TOPICS_PROGRAMS
(
	id_topic Integer NOT NULL,
	id_program Integer NOT NULL,
Primary Key (id_topic,id_program)
); 

Create table ASSIGNMENTS
(
	id_assignment Integer  NOT NULL AUTO_INCREMENT,
	id_topic Integer NOT NULL,
	id_type Integer NOT NULL,
	id_konsultant Integer NULL,
	date Datetime NULL,
	title varchar(50) NOT NULL,
	title_eng varchar(50) NOT NULL,
Primary Key (id_assignment)
); 

Create table TYPES
(
	id_type Integer  NOT NULL AUTO_INCREMENT,
	name varchar(30) NOT NULL, UNIQUE (name),
	abb varchar(5) NOT NULL, UNIQUE (abb),
	min_pages Integer NOT NULL,
	max_pages Integer NOT NULL,
Primary Key (id_type)
); 

Create table TOPICS_TYPES
(
	id_topic Integer NOT NULL,
	id_type Integer NOT NULL,
Primary Key (id_topic,id_type)
); 

Create table STEPS
(
	nb Integer NOT NULL, UNIQUE (nb),
	id_assignment Integer NOT NULL,
	text varchar(500) NOT NULL,
Primary Key (id_assignment)
); 

Create table LITERATURES
(
	nb Integer NOT NULL, UNIQUE (nb),
	id_assignment Integer NOT NULL,
	text varchar(500) NOT NULL,
Primary Key (id_assignment)
); 


Alter table TOPICS add  foreign key(id_teacher) references TEACHERS (id_teacher) on delete cascade;
Alter table ASSIGNMENTS add  foreign key(id_konsultant) references TEACHERS (id_teacher)  on delete Set Null ;
Alter table TEACHERS add  foreign key(id_office) references OFFICES (id_office)  on delete no action ;
Alter table REQUESTS add  foreign key(id_student) references STUDENTS (id_student)  on delete cascade ;
Alter table TOPICS add  foreign key(id_student) references STUDENTS (id_student)  on delete Set Null ;
Alter table REQUESTS add  foreign key(id_topic) references TOPICS (id_topic)  on delete cascade ;
Alter table TOPICS_PROGRAMS add  foreign key(id_topic) references TOPICS (id_topic)  on delete cascade ;
Alter table ASSIGNMENTS add  foreign key(id_topic) references TOPICS (id_topic)  on delete no action ;
Alter table TOPICS_TYPES add  foreign key(id_topic) references TOPICS (id_topic)  on delete cascade ;
Alter table PROGRAMS add  foreign key(id_parent) references PROGRAMS (id_program)  on delete no action ;
Alter table STUDENTS add  foreign key(id_program) references PROGRAMS (id_program)  on delete no action ;
Alter table TOPICS_PROGRAMS add  foreign key(id_program) references PROGRAMS (id_program)  on delete cascade ;
Alter table STEPS add  foreign key(id_assignment) references ASSIGNMENTS (id_assignment)  on delete cascade ;
Alter table LITERATURES add  foreign key(id_assignment) references ASSIGNMENTS (id_assignment)  on delete no action ;
Alter table TOPICS_TYPES add  foreign key(id_type) references TYPES (id_type)  on delete cascade ;
Alter table ASSIGNMENTS add  foreign key(id_type) references TYPES (id_type)  on delete no action ;