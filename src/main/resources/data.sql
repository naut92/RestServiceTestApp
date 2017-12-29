DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS typesanimals;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS log;
DROP TABLE IF EXISTS test;

DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS roles;

--USER TABLE
CREATE TABLE IF NOT EXISTS users (
  id SERIAL NOT NULL UNIQUE,
  firstname VARCHAR(255), --NOT NULL,
  lastname VARCHAR(255), --NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  dateborn DATE,--DATE,
  CONSTRAINT users_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

--LOG TABLE
CREATE TABLE IF NOT EXISTS log (
  id SERIAL NOT NULL UNIQUE,
  logstring VARCHAR(1000) NULL,
  PRIMARY KEY (id)
);

--TEST TABLE
CREATE TABLE IF NOT EXISTS test (
  id SERIAL NOT NULL UNIQUE,
  testcolumn VARCHAR(1000) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS typesanimals (
  id SERIAL NOT NULL UNIQUE,
  typeanimal VARCHAR(255) NOT NULL UNIQUE,
  CONSTRAINT typeanimals_pk PRIMARY KEY (id)
) WITH (
  OIDS=FALSE
);

CREATE TABLE IF NOT EXISTS animals (
  id SERIAL NOT NULL UNIQUE,
  users_id SERIAL NOT NULL,
  typesanimals_id SERIAL NOT NULL,
  animalname TEXT NOT NULL UNIQUE,
  sex TEXT NOT NULL,
  dateborn VARCHAR(255),--DATE,
  CONSTRAINT animals_pk PRIMARY KEY (id),
  CONSTRAINT animals_fk01 FOREIGN KEY(users_id) REFERENCES users (id),
  CONSTRAINT animals_fk02 FOREIGN KEY(typesanimals_id) REFERENCES typesanimals (id)
) WITH (
  OIDS=FALSE
);

--USERS
INSERT INTO users (firstname, lastname, email, dateborn) VALUES
  ('user1-fn', 'user1-ln', 'email1@email.com', '1989-01-01'),
  ('user2-fn', 'user2-ln', 'email2@email.com', '1990-02-02'),
  ('user3-fn', 'user3-ln', 'email3@email.com', '1991-03-03'),
  ('user4-fn', 'user4-ln', 'email4@email.com', '1992-04-04'),
  ('user5-fn', 'user5-ln', 'email5@email.com', '1993-05-05'),
  ('user6-fn', 'user6-ln', 'email6@email.com', '1994-06-06'),
  ('user7-fn', 'user7-ln', 'email7@email.com', '1995-07-07');

INSERT INTO typesanimals (typeanimal) VALUES
  ('cat'),
  ('dog'),
  ('bird'),
  ('fish');

INSERT INTO animals (users_id, typesanimals_id, animalname, sex, dateborn) VALUES
  (3, 1, 'animal1', 'm', '2013-13-06'),
  (3, 2, 'animal2', 'f', '2015-24-09'),
  (1, 3, 'animal34', 'f', '2011-15-02'),
  (4, 4, 'animal4', 'm', '2010-16-03'),
  (5, 2, 'animal5', 'f', '2009-17-04'),
  (5, 3, 'animal6', 'm', '2008-18-05'),
  (6, 1, 'animal7', 'm', '2007-19-06'),
  (6, 4, 'animal8', 'f', '2006-20-07'),
  (7, 3, 'animal9', 'f', '2005-21-08'),
  (7, 4, 'animal10', 'm', '2004-23-09'),
  (7, 2, 'animal11', 'f', '2003-22-10'),
  (7, 4, 'animal12', 'm', '2002-24-11');


--log
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 1');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 2');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 3');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 4');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 5');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 6');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 7');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 8');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 9');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 10');
INSERT INTO LOG(LOGSTRING) VALUES('TEST LOG 11');

--TEST
INSERT INTO test(TESTCOLUMN) VALUES('TEST COLUMN 1');
INSERT INTO test(TESTCOLUMN) VALUES('TEST COLUMN 2');
INSERT INTO test(TESTCOLUMN) VALUES('TEST COLUMN 3');
INSERT INTO test(TESTCOLUMN) VALUES('TEST COLUMN 4');