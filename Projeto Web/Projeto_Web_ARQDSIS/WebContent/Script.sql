/*EXCLUINDO O PROJETO*/
/*DROP schema ProjetoPPINT;*/

/*CRIANDO O SCHEMA*/
CREATE schema ProjetoPPINT default character set utf8;

use ProjetoPPINT;

set storage_engine = InnoDB;

/*CRIANDO AS TABELAS*/

CREATE TABLE ProjetoPPINT.tabelaAeronave(  

 codigo               BIGINT      NOT NULL AUTO_INCREMENT,
 nome                 VARCHAR(40) NOT NULL,
 qtdAssentos          BIGINT      NOT NULL,
 localAssentos        VARCHAR(30) NOT NULL,
 tipoAeronave         VARCHAR(30) NOT NULL,

 PRIMARY KEY (codigo)

);

CREATE TABLE ProjetoPPINT.tabelaPassagem(
codigo              BIGINT      NOT NULL AUTO_INCREMENT,
horaPartida         VARCHAR(10) NOT NULL,
dataPartida         VARCHAR(10) NOT NULL,
qtdPassageiros      BIGINT      NOT NULL,
perfil              VARCHAR(20) NOT NULL,
valor               DECIMAL(10) NOT NULL,
tipoPagamento       VARCHAR(40) NOT NULL,
codigoCliente		BIGINT      NOT NULL,
codigoVoo 			BIGINT      NOT NULL,
qtdMalas			INT,
assento				VARCHAR(40),
PRIMARY KEY(codigo)
);



CREATE TABLE ProjetoPPINT.tabelaDebito
(
	codigo         	    BIGINT      NOT NULL AUTO_INCREMENT,
	agencia             INT         NOT NULL,
	banco               VARCHAR(50) NOT NULL,
	contaCorrente       INT         NOT NULL,
	nomeTitular         VARCHAR(60) NOT NULL,
	cpf                 VARCHAR(20) NOT NULL,
	telefone            VARCHAR(20) NOT NULL,
	PRIMARY KEY(codigo)
);

CREATE TABLE ProjetoPPINT.tabelaVoo
(
codigo          BIGINT      NOT NULL AUTO_INCREMENT,
origem          VARCHAR(50) NOT NULL,
destino         VARCHAR(50) NOT NULL,
escala          VARCHAR(50) NOT NULL,
dt              VARCHAR(10) NOT NULL,
hora            VARCHAR(10) NOT NULL,
situacao        VARCHAR(10) NOT NULL,
codigoAeronave BIGINT not NULL,
PRIMARY KEY(codigo)
); 

CREATE TABLE ProjetoPPINT.tabelaCredito
(
 codigo 			BIGINT      NOT NULL AUTO_INCREMENT,
 tipoCartao         VARCHAR(20) NOT NULL,
 nomeTitular        VARCHAR(50) NOT NULL,
 cpf                VARCHAR(20) NOT NULL,
 numCartao          VARCHAR(20) NOT NULL,
 dtValidadeCartao   VARCHAR(10) NOT NULL,
 codSeguranca       INT         NOT NULL,
 PRIMARY KEY(codigo)
);



CREATE TABLE ProjetoPPINT.tabelaCliente
(
  codigo            BIGINT      NOT NULL AUTO_INCREMENT,  
  tipo              VARCHAR(20) NOT  NULL,
  tratamento        VARCHAR(10) NOT NULL,
  nome              VARCHAR(50) NOT NULL,
  dtNascimento      VARCHAR(10) NOT NULL,
  email             VARCHAR(45) NOT NULL,
  telefone          VARCHAR(15) NOT NULL,
  cpf 				VARCHAR(15) NOT NULL,
  PRIMARY KEY(codigo)
);

CREATE TABLE tabelaPassCred
(
	tabelaPassagem_codigo BIGINT      NOT NULL,
	tabelaCredito_codigo BIGINT      NOT NULL
);

CREATE TABLE tabelaPassDeb
(
	tabelaPassagem_codigo BIGINT      NOT NULL,
	tabelaDebito_codigo BIGINT      NOT NULL
);

CREATE TABLE tabelaReembolso
(
    codigo BIGINT NOT NULL AUTO_INCREMENT,
    agencia VARCHAR(20) NOT NULL,
    banco VARCHAR(20) NOT NULL,
    conta VARCHAR(20) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    nomeTitula VARCHAR(20) NOT NULL,
    valorDevolucao DECIMAL(10) NOT NULL,
    codPassagem BIGINT NOT NULL,
    primary key(codigo)
);

/*INSERINDO DADOS NO BANCO*/

INSERT INTO `ProjetoPPINT`.`tabelaAeronave` 
(`codigo`, `nome`, `qtdAssentos`, `localAssentos`, `tipoAeronave`) 
VALUES ('1', 'Jatto', '2', 'Janela', 'Jato');

INSERT INTO `ProjetoPPINT`.`tabelaCliente` 
(`codigo`, `tipo`, `tratamento`, `nome`, `dtNascimento`, `email`, `telefone`, `cpf`) 
VALUES ('1', 'Adulto', 'Senhora', 'Paloma', '22/03/1990', 'palomacarreira@hotmail.com', '11-98795-4949', '53739705809');

INSERT INTO `ProjetoPPINT`.`tabelaCredito` (`codigo`, `tipoCartao`, `nomeTitular`, `cpf`, `numCartao`, `dtValidadeCartao`, `codSeguranca`) 
VALUES ('1', 'visa', 'Paloma Carreira', '53739705809', '099099099', '11/11/2080', '20');

INSERT INTO `ProjetoPPINT`.`tabelaDebito` (`codigo`, `agencia`, `banco`, `contaCorrente`, `nomeTitular`, `cpf`, `telefone`) 
VALUES ('1', '0521', 'Banco do Brasil',  '05212335', 'Paloma', '53739705809','11-98795-4949');

INSERT INTO `ProjetoPPINT`.`tabelaPassagem` 
(`codigo`, `horaPartida`, `dataPartida`, `qtdPassageiros`, `perfil`, `valor`, `tipoPagamento`, `codigoCliente`, `codigoVoo`, `qtdMalas`, `assento`) 
VALUES ('1', '11:30', '01/01/2016', '3', 'Adulto', '1500', 'visa', '1', '1', '2', 'Janela');

INSERT INTO `ProjetoPPINT`.`tabelaPassagem` 
(`codigo`, `horaPartida`, `dataPartida`, `qtdPassageiros`, `perfil`, `valor`, `tipoPagamento`, `codigoCliente`, `codigoVoo`, `qtdMalas`, `assento`) 
VALUES ('2', '13:30', '01/07/2016', '3', 'Adulto', '1800', 'visa', '1', '2', '2', 'Janela');

INSERT INTO `ProjetoPPINT`.`tabelaPassagem` 
(`codigo`, `horaPartida`, `dataPartida`, `qtdPassageiros`, `perfil`, `valor`, `tipoPagamento`, `codigoCliente`, `codigoVoo`, `qtdMalas`, `assento`) 
VALUES ('3', '15:30', '01/04/2016', '3', 'Adulto', '1900', 'visa', '1', '3', '2', 'Janela');

INSERT INTO `ProjetoPPINT`.`tabelaPassagem` 
(`codigo`, `horaPartida`, `dataPartida`, `qtdPassageiros`, `perfil`, `valor`, `tipoPagamento`, `codigoCliente`, `codigoVoo`, `qtdMalas`, `assento`) 
VALUES ('4', '12:30', '01/03/2016', '3', 'Adulto', '1300', 'visa', '1', '4', '2', 'Janela');

INSERT INTO `ProjetoPPINT`.`tabelaPassagem` 
(`codigo`, `horaPartida`, `dataPartida`, `qtdPassageiros`, `perfil`, `valor`, `tipoPagamento`, `codigoCliente`, `codigoVoo`, `qtdMalas`, `assento`) 
VALUES ('5', '08:30', '01/05/2016', '3', 'Adulto', '1100', 'visa', '1', '5', '2', 'Janela');

INSERT INTO `ProjetoPPINT`.`tabelaPassagem` 
(`codigo`, `horaPartida`, `dataPartida`, `qtdPassageiros`, `perfil`, `valor`, `tipoPagamento`, `codigoCliente`, `codigoVoo`, `qtdMalas`, `assento`) 
VALUES ('6', '14:30', '01/02/2016', '3', 'Adulto', '1560', 'visa', '1', '6', '2', 'Janela');

INSERT INTO `ProjetoPPINT`.`tabelaReembolso` (`codigo`, `agencia`, `banco`, `conta`, `cpf`, `nomeTitula`, `valorDevolucao`, `codPassagem`) 
VALUES ('1', '215', '01', '012554', '53739705809', 'Paloma', '150.00', '1');

INSERT INTO `ProjetoPPINT`.`tabelaVoo` (`codigo`, `origem`, `destino`, `escala`, `dt`, `hora`, `situacao`, `codigoAeronave`) 
VALUES ('1', 'São Paulo', 'Fortaleza', 'Nada', '01/08/2015', '01:35', 'Aprovado', '1');

INSERT INTO `ProjetoPPINT`.`tabelaVoo` (`codigo`, `origem`, `destino`, `escala`, `dt`, `hora`, `situacao`, `codigoAeronave`) 
VALUES ('2', 'Fortaleza', 'São Paulo', 'Nada', '01/08/2015', '01:35', 'Aprovado', '1');

INSERT INTO `ProjetoPPINT`.`tabelaVoo` (`codigo`, `origem`, `destino`, `escala`, `dt`, `hora`, `situacao`, `codigoAeronave`) 
VALUES ('3', 'São Paulo', 'Bahia', 'Nada', '01/08/2015', '01:35', 'Aprovado', '1');

INSERT INTO `ProjetoPPINT`.`tabelaVoo` (`codigo`, `origem`, `destino`, `escala`, `dt`, `hora`, `situacao`, `codigoAeronave`) 
VALUES ('4', 'Bahia', 'São Paulo', 'Nada', '01/08/2015', '01:35', 'Aprovado', '1');

INSERT INTO `ProjetoPPINT`.`tabelaVoo` (`codigo`, `origem`, `destino`, `escala`, `dt`, `hora`, `situacao`, `codigoAeronave`) 
VALUES ('5', 'Bahia', 'Fortaleza', 'Nada', '01/08/2015', '01:35', 'Aprovado', '1');

INSERT INTO `ProjetoPPINT`.`tabelaVoo` (`codigo`, `origem`, `destino`, `escala`, `dt`, `hora`, `situacao`, `codigoAeronave`) 
VALUES ('6', 'Fortaleza', 'Bahia', 'Nada', '01/08/2015', '01:35', 'Aprovado', '1');