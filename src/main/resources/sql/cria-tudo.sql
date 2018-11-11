CREATE DATABASE opengates;

use opengates;

CREATE TABLE Email(
  id int NOT NULL AUTO_INCREMENT,
  html TEXT NOT NULL ,
  destinatario VARCHAR(255) NOT NULL,
  assunto VARCHAR(50) NOT NULL ,
  enviado BOOL default 0,
  dataEnvio DATETIME,
  CONSTRAINT PK_EnvioEmail PRIMARY KEY (id)
);

CREATE TABLE Cargo(
  id int NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(60),
  CONSTRAINT PK_Cargo PRIMARY KEY (id)
);

CREATE TABLE Disciplina(
  id int NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(70),
  sigla VARCHAR(10),
  CONSTRAINT PK_Disciplina PRIMARY KEY (id)
);
CREATE TABLE Curso(
  id int NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(70),
  sigla VARCHAR(10),
  CONSTRAINT PK_Curso PRIMARY KEY (id)
);
CREATE TABLE Aluno(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(200),
  fotoBase64 TEXT,
  usuarioId INT,
  FOREIGN KEY (usuarioId) REFERENCES Usuario(id)
  CONSTRAINT PK_Aluno PRIMARY KEY (id)
);

CREATE TABLE Funcionario(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(200),
  fotoBase64 TEXT,
  usuarioId INT,
  cargoId INT,
  FOREIGN KEY (usuarioId) REFERENCES Usuario(id),
  FOREIGN KEY (cargoId) REFERENCES Cargo(id),
  CONSTRAINT PK_Funcionario PRIMARY KEY (id)
);

CREATE TABLE Usuario(
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR (200),
  senha VARCHAR (200),
  acessaSistema BOOL DEFAULT false,
  tipoUsuario ENUM('ADMINISTRADOR', 'VISITANTE','FUNCIONARIO', 'SECRETARIA', 'ALUNO') NOT null ,
  codigoEmail varchar (10),
  cpf INT(11) NOT NULL UNIQUE ,
  CONSTRAINT PK_Usuario PRIMARY KEY (id)
);

CREATE TABLE ArquivosMatricula(
  id INT NOT NULL AUTO_INCREMENT,
  nomeArquivoFotos VARCHAR(100) ,
  nomeArquivoCsv VARCHAR(100),
  urlArquivoFotos VARCHAR(100),
  urlCsv VARCHAR(100),
  numeroMatriculas int(4),
  quantidadeErros int (4),
  CONSTRAINT PK_ArquivosMatricula PRIMARY KEY (id)
);

CREATE TABLE Validacao(
  id int not null AUTO_INCREMENT,
  usuarioId INT,
  permitida BOOL default 0,
  acao ENUM('ENTRADA', 'SAIDA'),
  mensagem VARCHAR (150),
  FOREIGN KEY (usuarioId) REFERENCES Usuario(id),
  CONSTRAINT PK_Validacao PRIMARY KEY (id)
);

CREATE TABLE CredenciamentoAluno(
    id int not null AUTO    _INCREMENT,
    alunoId INT,
    cursoId INT,
    dataCredenciamento DATETIME,
    validoAte DATETIME,
    semestre int(1),
    periodo ENUM('MANHA','TARDE','NOITE'),
    FOREIGN KEY (alunoId) REFERENCES Aluno(id),
    FOREIGN KEY (cursoId) REFERENCES Curso(id),
    CONSTRAINT PK_CredenciamentoAluno PRIMARY KEY (id)
);