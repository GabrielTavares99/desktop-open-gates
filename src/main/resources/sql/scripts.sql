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
ALTER TABLE Usuario
ALTER COLUMN cpf VARCHAR(11);


ALTER TABLE EnvioEmail RENAME TO Email;

INSERT INTO EmailAnexo
value (caminhoAnexo, emailId) VALUES (?,?);

SELECT a.id,a.nome,a.fotoBase64,a.ra, FROM Aluno a  INNER JOIN on Usuario u a.usuarioId  = u.id WHERE u.email = ?;

SELECT * FROM Usuario;
describe Usuario;
TRUNCATE Usuario;

ALTER TABLE Aluno
drop column fotoBase64;

ALTER TABLE Usuario
add fotoBase64 LONGTEXT;

drop table Aluno;

SELECT a.id,a.nome,a.fotoBase64,a.ra, a.usuarioId FROM Aluno a INNER JOIN Usuario u on a.usuarioId  = u.id WHERE u.email = 'adm';
SELECT a.id,a.nome,a.fotoBase64,a.ra, a.usuarioId FROM Aluno a INNER JOIN Usuario u on a.usuarioId  = u.id WHERE u.email = 'adm';
DESCRIBE Aluno;

SELECT a.id,a.nome,a.fotoBase64,a.ra, a.usuarioId FROM Aluno a INNER JOIN Usuario u on a.usuarioId  = u.id WHERE u.email = 'weverson.t@gmail.com';

SELECT * FROM Usuario;
SELECT * from Aluno;
delete from Usuario where email = 'weverson.t@gmail.com';