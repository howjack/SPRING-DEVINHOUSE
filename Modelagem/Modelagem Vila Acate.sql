Modelagem Vila Acate

-Pessoa
    id serial PRIMARY KEY
    name varchar(60) NOT NULL
    surname varchar(60)
    birthdate date NOT NULL
    rent decimal(10,2) NOT NULL
    cpf varchar(60) UNIQUE NOT NULL
    email varchar(255) UNIQUE NOT NULL
    password varchar(255) NOT NULL
    
   
    