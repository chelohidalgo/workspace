CREATE DATABASE test;

--IMPORTANTE!!
 \c test; 

CREATE TABLE role(
 role_id serial PRIMARY KEY,
 role_name VARCHAR (255) UNIQUE NOT NULL
);

CREATE TABLE account(
 user_id integer PRIMARY KEY,
 username VARCHAR (50) UNIQUE NOT NULL,
 password VARCHAR (50) NOT NULL,
 email VARCHAR (355) UNIQUE NOT NULL,
 created_on TIMESTAMP NOT NULL,
 last_login TIMESTAMP,
 role_id integer NOT NULL,
 CONSTRAINT account_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE withdraw(
 id serial PRIMARY KEY,
 user_id integer NOT NULL,
 state VARCHAR (3) NOT NULL,
 value float NOT NULL,
 date_withdraw_on TIMESTAMP NOT NULL,
  date_processed_on TIMESTAMP NULL
);


CREATE TABLE money(
 id serial PRIMARY KEY,
 amount float NOT NULL,
 amount_available float NULL,
 date_income_on TIMESTAMP NOT NULL
);

create user admin createdb test password 'admin';
GRANT ALL PRIVILEGES ON database test TO admin;
GRANT ALL PRIVILEGES ON table money TO admin;
GRANT ALL PRIVILEGES ON table account TO admin;
GRANT ALL PRIVILEGES ON table withdraw TO admin;
GRANT ALL PRIVILEGES ON sequence money_id_seq TO admin;
GRANT ALL PRIVILEGES ON sequence withdraw_id_seq TO admin;

insert into role (role_name) values('custodio');
insert into role (role_name) values('publico');
insert into account(user_id, username,password,email,created_on,last_login,role_id) values(1,'admin','admin','admin@softwareevolutivo.net',now(),now(),1);
insert into account(user_id, username,password,email,created_on,last_login,role_id) values(1001,'user1','user1','user1@softwareevolutivo.net',now(),now(),2);
insert into account(user_id, username,password,email,created_on,last_login,role_id) values(1002,'user2','user2','user2@softwareevolutivo.net',now(),now(),2);
insert into account(user_id, username,password,email,created_on,last_login,role_id) values(1003,'user3','user3','user3@softwareevolutivo.net',now(),now(),2);
insert into account(user_id, username,password,email,created_on,last_login,role_id) values(1004,'user4','user4','user4@softwareevolutivo.net',now(),now(),2);
