CREATE DATABASE vilaAcate;

CREATE TABLE people(id SERIAL PRIMARY KEY, name varchar(60) NOT NULL, surname varchar(60), birth_date date NOT NULL, 
	rent decimal(10,2) NOT NULL, cpf varchar(60) UNIQUE NOT NULL, email varchar(255) UNIQUE NOT NULL, password varchar(255) NOT NULL);

INSERT INTO people(name,surname, birth_date, rent, cpf, email, password) 
	VALUES  ('Phelipe', 'Fagundes', '1998/06/26', '800.08', '999.999.999-99' , 'phelipe44@gmail.com', 'Phelipe@99'),
			('Pedro', 'Alves', '1999/02/12', '400.47', '888.888.888-88' , 'pedro47@gmail.com', 'Pedro!88');
		
CREATE ROLE usuario NOSUPERUSER NOCREATEDB NOCREATEROLE NOINHERIT LOGIN;

GRANT SELECT ON TABLE public.people TO usuario;

CREATE ROLE administrador SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN PASSWORD '123456';

GRANT ALL ON TABLE public.people TO administrador;

------------------------used in the application--------------------------------------

SELECT * FROM people; --LIST ALL THE PEOPLES--

SELECT * FROM people WHERE id = 2; --GET BY ID--

SELECT * FROM people WHERE EXTRACT(YEAR FROM birth_date) <= 1998; --GET BY AGE--

DELETE FROM people WHERE id = 2; --DELETE--

INSERT INTO people(name,surname, birth_date, rent, cpf, email, password) --CREATE(POST)--
	VALUES  (?, ?, ?, ?, ?, ?, ?);


SELECT * FROM people WHERE name LIKE('P%'); --GET BY NAME--

SELECT rent FROM people; --LIST ALL RENT FROM TABLE--