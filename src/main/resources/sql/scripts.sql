CREATE DATABASE opengates;

use opengates;

CREATE TABLE EnvioEmail(
  id int NOT NULL AUTO_INCREMENT,
  html TEXT NOT NULL ,
  destinatario VARCHAR(255) NOT NULL,
  assunto VARCHAR(50) NOT NULL ,
  enviado BOOL default 0,
  dataEnvio DATETIME,
  CONSTRAINT PK_EnvioEmail PRIMARY KEY (id)
);
CREATE TABLE EmailAnexo(
  id int NOT NULL AUTO_INCREMENT,
  caminhoAnexo VARCHAR (50),
  emailId int,
  FOREIGN KEY (emailId) REFERENCES Email(id),
  CONSTRAINT PK_EmailAnexo PRIMARY KEY (id)
);
UPDATE EnvioEmail
SET
  html = ?,
  destinatario = ?,
  assunto = ?,
  enviado = ?,
  dataEnvio = ?
WHERE id = ?;

DROP TABLE EnvioEmail;

SELECT destinatario, assunto FROM EnvioEmail where enviado = true;
ALTER TABLE EnvioEmail
ADD dataEnvio DATETIME;

ALTER TABLE EnvioEmail RENAME TO Email;

INSERT INTO EmailAnexo
value (caminhoAnexo, emailId) VALUES (?,?);