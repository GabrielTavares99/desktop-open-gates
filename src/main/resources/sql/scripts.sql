CREATE DATABASE opengates;

use opengates;

CREATE TABLE EnvioEmail(
  id int NOT NULL AUTO_INCREMENT,
  html TEXT NOT NULL ,
  destinatario VARCHAR(255) NOT NULL,
  assunto VARCHAR(50) NOT NULL ,
  enviado BOOL default 0,
  CONSTRAINT PK_EnvioEmail PRIMARY KEY (id)
);

DROP TABLE EnvioEmail;