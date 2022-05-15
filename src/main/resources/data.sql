create table Student
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);

INSERT INTO Student (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(11,  'Ducat', 'Noida',sysdate());
INSERT INTO Student (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(12,  'NIIT', 'Delhi',sysdate());
INSERT INTO Student (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(13,  'Aptech', 'Ghaziabad',sysdate());
