# CREATE DATABASE userDataBase;

CREATE TABLE users (

  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR (30),
  pass VARCHAR (30),
  PRIMARY KEY (id)

);

CREATE TABLE notification (

  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR (30),
  message VARCHAR (250),
  user_id INT,
  PRIMARY KEY (id)

);

INSERT INTO notification (type, message, user_id)
    VALUES ('INFO','Hi DEX', 1);

INSERT INTO notification (type, message, user_id)
    VALUES ('WARN','Some warn notification', 1);

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