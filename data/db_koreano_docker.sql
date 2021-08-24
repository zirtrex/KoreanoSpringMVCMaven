CREATE SCHEMA IF NOT EXISTS `db_koreano` DEFAULT CHARACTER SET utf8 ;
USE `db_koreano`;
CREATE TABLE IF NOT EXISTS `sistema_koreano`.`equipo` (
	`codEquipo` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(45) NULL,
	`marca` VARCHAR(45) NULL,
	`modelo` VARCHAR(45) NULL,
	`placa` VARCHAR(45) NULL,
	`categoria` VARCHAR(45) NULL,
	`horometro` DECIMAL(10,2) NULL,
	PRIMARY KEY (`codEquipo`)
)ENGINE = InnoDB;