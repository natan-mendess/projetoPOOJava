DROP SCHEMA IF EXISTS `pukapuka` ;

CREATE SCHEMA IF NOT EXISTS `pukapuka`;
USE `pukapuka` ;

DROP TABLE IF EXISTS `pukapuka`.`comprador` ;

CREATE TABLE IF NOT EXISTS `pukapuka`.`comprador` (
  `idcom` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `cpf` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`idcom`));

DROP TABLE IF EXISTS `pukapuka`.`livro` ;

CREATE TABLE IF NOT EXISTS `pukapuka`.`livro` (
  `idlivro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(60) NOT NULL,
  `preco` FLOAT NOT NULL,
  PRIMARY KEY (`idlivro`));

DROP TABLE IF EXISTS `pukapuka`.`vendedor` ;

CREATE TABLE IF NOT EXISTS `pukapuka`.`vendedor` (
  `idvend` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `cpf` VARCHAR(12) NOT NULL,
  `turno` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idvend`));

DROP TABLE IF EXISTS `pukapuka`.`venda` ;

CREATE TABLE IF NOT EXISTS `pukapuka`.`venda` (
  `idvenda` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `idcom` INT NOT NULL,
  `idlivro` INT NOT NULL,
  `idvend` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  CONSTRAINT `venda_ibfk_1`
    FOREIGN KEY (`idcom`)
    REFERENCES `pukapuka`.`comprador` (`idcom`),
  CONSTRAINT `venda_ibfk_2`
    FOREIGN KEY (`idlivro`)
    REFERENCES `pukapuka`.`livro` (`idlivro`),
  CONSTRAINT `venda_ibfk_3`
    FOREIGN KEY (`idvend`)
    REFERENCES `pukapuka`.`vendedor` (`idvend`));
