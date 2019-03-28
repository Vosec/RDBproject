Insert into OFFICES (name, abb, is_external) values ('Institut MTI', 'MTI', 0);
Insert into OFFICES (name, abb, is_external) values ('Institut ITE', 'ITE', 0);
Insert into OFFICES (name, abb, is_external) values ('Institut NTI', 'NTI', 0);
Insert into OFFICES (name, abb, is_external) values ('Jablotron, Jablonec nad Nisou', null , 1);

Insert into TYPES (name, abb, min_pages, max_pages) values ('Bakalarsky projekt', 'PRJ', 20, 30);
Insert into TYPES (name, abb, min_pages, max_pages) values ('Magistersky projekt', 'PRO', 30, 40);
Insert into TYPES (name, abb, min_pages, max_pages) values ('Bakalarska prace', 'BP', 30, 40);
Insert into TYPES (name, abb, min_pages, max_pages) values ('Diplomova prace', 'DP', 40, 50);

Insert into PROGRAMS (id_parent, name, abb) values (1, 'Bakalar', 'BS');
Insert into PROGRAMS (id_parent, name, abb) values (2, 'Magistr', 'MS');
Insert into PROGRAMS (id_parent, name, abb) values (1, 'Informacni technologie', 'BS IT');
Insert into PROGRAMS (id_parent, name, abb) values (1, 'Informatika a logistika', 'BS IL');
Insert into PROGRAMS (id_parent, name, abb) values (1, 'Informatika a elektronika', 'BS IE');
Insert into PROGRAMS (id_parent, name, abb) values (2, 'Informacni technologie', 'MS IT');
Insert into PROGRAMS (id_parent, name, abb) values (2, 'Informatika a elektronika', 'MS IE');
Insert into PROGRAMS (id_parent, name, abb) values (1, 'Nanotechnologie', 'BS NA');

Insert into TEACHERS (id_office, name, surname, email, is_admin) values (1, 'Jana', 'Vitvarova', 'jana.vitvarova@tul.cz', 1);
Insert into TEACHERS (id_office, name, surname, email, is_admin) values (1, 'Pavel', 'Tyl', 'pavel.tyl@tul.cz', 0);
Insert into TEACHERS (id_office, name, surname, email, is_admin) values (1, 'Roman', 'Spanek', 'roman.spanek@tul.cz', 0);
Insert into TEACHERS (id_office, name, surname, email, is_admin) values (2, 'Jiri', 'Jenicek', 'jiri.jenicek@tul.cz', 0);
Insert into TEACHERS (id_office, name, surname, email, is_admin) values (2, 'Zdenek', 'Pliva', 'zdenek.pliva@tul.cz', 0);
Insert into TEACHERS (id_office, name, surname, email, is_admin) values (3, 'Jan', 'Turcinek', 'jan.turcinek@jablotron.cz', 0);

Insert into STUDENTS (id_program, name, surname, email) values (6, 'Daniel', 'Madera', 'daniel.madera@tul.cz');
Insert into STUDENTS (id_program, name, surname, email) values (7, 'Tomas', 'Krizek', 'tomas.krizek@tul.cz');
Insert into STUDENTS (id_program, name, surname, email) values (3, 'Jan', 'Lankas', 'jan.lankas@tul.cz');
Insert into STUDENTS (id_program, name, surname, email) values (3, 'David', 'Priplata', 'david.priplata@tul.cz');
Insert into STUDENTS (id_program, name, surname, email) values (3, 'Milan', 'Honcu', 'milan.honcu@tul.cz');
Insert into STUDENTS (id_program, name, surname, email) values (4, 'Jakub', 'Venglar', 'jakub.venglar@tul.cz');
Insert into STUDENTS (id_program, name, surname, email) values (3, 'Tomas', 'Vejr', 'tomas.vejr@tul.cz');
Insert into STUDENTS (id_program, name, surname, email) values (3, 'Jiri', 'Samal', 'jiri.samal@tul.cz');

Insert into TOPICS (id_teacher, id_student, title, abstract, year) values (1, 1, 'Topic1', 'Abstrakt1', 2014);
Insert into TOPICS (id_teacher, id_student, title, abstract, year) values (1, 6, 'Topic2', 'Abstrakt2', 2013);
Insert into TOPICS (id_teacher, title, abstract, year) values (2, 'Topic3', 'Abstrakt3', 2014);
Insert into TOPICS (id_teacher, id_student, title, abstract, year) values (2, 4, 'Topic4', 'Abstrakt4', 2013);
Insert into TOPICS (id_teacher, title, abstract, year) values (2, 'Topic5', 'Abstrakt5', 2014);
Insert into TOPICS (id_teacher, id_student, title, abstract, year) values (3, 3, 'Topic6', 'Abstrakt6', 2014);
Insert into TOPICS (id_teacher, id_student, title, abstract, year) values (4, 2, 'Topic7', 'Abstrakt7', 2014);
Insert into TOPICS (id_teacher, title, abstract, year) values (4, 'Topic8', 'Abstrakt8', 2014);
Insert into TOPICS (id_teacher, title, abstract, year) values (4, 'Topic9', 'Abstrakt9', 2014);

Insert into REQUESTS(id_student, id_topic) values (3, 3);
Insert into REQUESTS(id_student, id_topic) values (7, 3);
Insert into REQUESTS(id_student, id_topic) values (8, 3);
Insert into REQUESTS(id_student, id_topic) values (8, 9);

Insert into TOPICS_PROGRAMS values (1, 6);
Insert into TOPICS_PROGRAMS values (1, 7);
Insert into TOPICS_PROGRAMS values (1, 3);
Insert into TOPICS_PROGRAMS values (1, 4);
Insert into TOPICS_PROGRAMS values (1, 5);
Insert into TOPICS_PROGRAMS values (2, 3);
Insert into TOPICS_PROGRAMS values (2, 5);
Insert into TOPICS_PROGRAMS values (3, 3);
Insert into TOPICS_PROGRAMS values (3, 4);
Insert into TOPICS_PROGRAMS values (3, 5);
Insert into TOPICS_PROGRAMS values (4, 3);
Insert into TOPICS_PROGRAMS values (5, 6);
Insert into TOPICS_PROGRAMS values (5, 7);
Insert into TOPICS_PROGRAMS values (6, 3);
Insert into TOPICS_PROGRAMS values (6, 4);
Insert into TOPICS_PROGRAMS values (6, 5);
Insert into TOPICS_PROGRAMS values (7, 7);
Insert into TOPICS_PROGRAMS values (8, 7);
Insert into TOPICS_PROGRAMS values (9, 3);
Insert into TOPICS_PROGRAMS values (9, 8);

Insert into TOPICS_TYPES values (1, 1);
Insert into TOPICS_TYPES values (1, 2);
Insert into TOPICS_TYPES values (1, 3);
Insert into TOPICS_TYPES values (1, 4);
Insert into TOPICS_TYPES values (2, 1);
Insert into TOPICS_TYPES values (2, 2);
Insert into TOPICS_TYPES values (3, 1);
Insert into TOPICS_TYPES values (3, 2);
Insert into TOPICS_TYPES values (4, 1);
Insert into TOPICS_TYPES values (4, 2);
Insert into TOPICS_TYPES values (4, 3);
Insert into TOPICS_TYPES values (4, 4);
Insert into TOPICS_TYPES values (5, 4);
Insert into TOPICS_TYPES values (6, 1);
Insert into TOPICS_TYPES values (6, 2);
Insert into TOPICS_TYPES values (7, 3);
Insert into TOPICS_TYPES values (7, 4);
Insert into TOPICS_TYPES values (8, 3);
Insert into TOPICS_TYPES values (9, 1);
Insert into TOPICS_TYPES values (9, 2);

Insert into ASSIGNMENTS (id_topic, id_type, id_konsultant, title, title_eng) values (1, 3, null, 'title11', 'title_eng1');
Insert into ASSIGNMENTS (id_topic, id_type, id_konsultant, title, title_eng) values (7, 4, null, 'title77', 'title_eng7');
Insert into ASSIGNMENTS (id_topic, id_type, id_konsultant, title, title_eng) values (6, 2, 2, 'title66', 'title_eng6');
Insert into ASSIGNMENTS (id_topic, id_type, id_konsultant, title, title_eng) values (2, 2, 6, 'title22', 'title_eng2');









 


