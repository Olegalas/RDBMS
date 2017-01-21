CREATE DATABASE userDataBase;

USE userDataBase;

CREATE TABLE users (

  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR (30),
  pass VARCHAR (30),
  PRIMARY KEY (id)

);


INSERT INTO users (login, pass)
VALUES ('DEX', 'pass');

INSERT INTO users (login, pass)
VALUES ('DAN', 'pass2');

INSERT INTO users (login, pass)
VALUES ('JACK', 'pass3');

INSERT INTO users (login, pass)
VALUES ('JASON', 'pass4');

INSERT INTO users (login, pass)
VALUES ('JAMES', 'pass5');

INSERT INTO users (login, pass)
VALUES ('ALEX', 'pass6');