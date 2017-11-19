-- MySQL Script generated by MySQL Workbench
-- Sun Nov 19 16:06:32 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbregistrodocumento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbregistrodocumento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbregistrodocumento` DEFAULT CHARACTER SET utf8 ;
USE `dbregistrodocumento` ;

-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`persona_trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`persona_trabajador` (
  `idptrabajador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `apaterno` VARCHAR(25) NOT NULL,
  `amaterno` VARCHAR(25) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `cargo_institucion` VARCHAR(45) NOT NULL,
  `modalidad_contrato` VARCHAR(45) NOT NULL,
  `tipo_documento` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`idptrabajador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`trabajador` (
  `idptrabajador` INT NOT NULL,
  `num_documento` VARCHAR(8) NOT NULL,
  `celular` VARCHAR(9) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `fecha_registro` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idptrabajador`),
  UNIQUE INDEX `num_documento_UNIQUE` (`num_documento` ASC),
  CONSTRAINT `fk_persona_trabajador_trabajador`
    FOREIGN KEY (`idptrabajador`)
    REFERENCES `dbregistrodocumento`.`persona_trabajador` (`idptrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`acceso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`acceso` (
  `idacceso` INT NOT NULL AUTO_INCREMENT,
  `idtrabajador` INT NOT NULL,
  `acceso` VARCHAR(13) NOT NULL,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `estado` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`idacceso`),
  INDEX `fk_trabajador_acceso_idx` (`idtrabajador` ASC),
  UNIQUE INDEX `acceso_UNIQUE` (`acceso` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `estado_UNIQUE` (`estado` ASC),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC),
  CONSTRAINT `fk_trabajador_acceso`
    FOREIGN KEY (`idtrabajador`)
    REFERENCES `dbregistrodocumento`.`trabajador` (`idptrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`asistenciales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`asistenciales` (
  `idasistenciales` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `cargo_institucion` VARCHAR(45) NOT NULL,
  `modalidad_contrato` VARCHAR(45) NOT NULL,
  `colegiatura` VARCHAR(45) NOT NULL,
  `num_colegiatura` VARCHAR(45) NOT NULL,
  `profesion` VARCHAR(45) NOT NULL,
  `tipo_documento` VARCHAR(30) NOT NULL,
  `num_documento` VARCHAR(10) NOT NULL,
  `celular` VARCHAR(15) NOT NULL,
  `fecha_registro` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idasistenciales`),
  UNIQUE INDEX `num_documento_UNIQUE` (`num_documento` ASC),
  UNIQUE INDEX `num_colegiatura_UNIQUE` (`num_colegiatura` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`administrativos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`administrativos` (
  `idadministrativos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `cargo_institucion` VARCHAR(45) NOT NULL,
  `modalidad_contrato` VARCHAR(45) NOT NULL,
  `profesion` VARCHAR(45) NOT NULL,
  `tipo_documento` VARCHAR(10) NOT NULL,
  `num_documento` VARCHAR(10) NOT NULL,
  `celular` VARCHAR(45) NOT NULL,
  `fecha_registro` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idadministrativos`),
  UNIQUE INDEX `num_documento_UNIQUE` (`num_documento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`oficio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`oficio` (
  `idoficios` INT NOT NULL AUTO_INCREMENT,
  `idadministrativos` INT NOT NULL,
  `idasistenciales` INT NOT NULL,
  `num_correlativo` VARCHAR(45) NOT NULL,
  `atencion` VARCHAR(45) NOT NULL,
  `asunto` VARCHAR(45) NOT NULL,
  `cuerpo` VARCHAR(1000) NOT NULL,
  `membrete` VARCHAR(45) NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idoficios`),
  INDEX `fk_asistenciales_oficio_idx` (`idasistenciales` ASC),
  INDEX `fk_administrativos_oficio_idx` (`idadministrativos` ASC),
  CONSTRAINT `fk_asistenciales_oficio`
    FOREIGN KEY (`idasistenciales`)
    REFERENCES `dbregistrodocumento`.`asistenciales` (`idasistenciales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_administrativos_oficio`
    FOREIGN KEY (`idadministrativos`)
    REFERENCES `dbregistrodocumento`.`administrativos` (`idadministrativos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`recepcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`recepcion` (
  `idrecepcion` INT NOT NULL AUTO_INCREMENT,
  `correlativo` VARCHAR(30) NOT NULL,
  `referencia` VARCHAR(60) NOT NULL,
  `asunto` VARCHAR(45) NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  `emisor` VARCHAR(45) NOT NULL,
  `recepcionado` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrecepcion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`informe_medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`informe_medico` (
  `idinforme_medico` INT NOT NULL AUTO_INCREMENT,
  `idasistenciales` INT NOT NULL,
  `correlativo_informemedico` VARCHAR(45) NOT NULL,
  `nombre_paciente` VARCHAR(45) NOT NULL,
  `apellidos_paciente` VARCHAR(45) NOT NULL,
  `historia_clinica` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `edad` VARCHAR(45) NOT NULL,
  `tipo_documento` VARCHAR(45) NOT NULL,
  `num_documento` VARCHAR(45) NOT NULL,
  `fecha_registro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idinforme_medico`),
  INDEX `fk_asistenciales_informa_medico_idx` (`idasistenciales` ASC),
  UNIQUE INDEX `correlativo_informemedico_UNIQUE` (`correlativo_informemedico` ASC),
  CONSTRAINT `fk_asistenciales_informa_medico`
    FOREIGN KEY (`idasistenciales`)
    REFERENCES `dbregistrodocumento`.`asistenciales` (`idasistenciales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`constancia_nacimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`constancia_nacimiento` (
  `idconstancia_nacimiento` INT NOT NULL AUTO_INCREMENT,
  `idasistenciales` INT NOT NULL,
  `correlativo_constancia` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `tipo_doc` VARCHAR(45) NOT NULL,
  `num_doc` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `historia_clinica` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `peso` VARCHAR(45) NOT NULL,
  `talla` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `hora_nacimiento` VARCHAR(45) NOT NULL,
  `num_doc_nacido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento_letra` VARCHAR(45) NOT NULL,
  `fecha_registro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idconstancia_nacimiento`),
  UNIQUE INDEX `num_doc_UNIQUE` (`num_doc` ASC),
  UNIQUE INDEX `num_doc_nacido_UNIQUE` (`num_doc_nacido` ASC),
  UNIQUE INDEX `correlativo_constancia_UNIQUE` (`correlativo_constancia` ASC),
  UNIQUE INDEX `idasistenciales_UNIQUE` (`idasistenciales` ASC),
  CONSTRAINT `fk_asistenciales_constancia_nacimiento`
    FOREIGN KEY (`idasistenciales`)
    REFERENCES `dbregistrodocumento`.`asistenciales` (`idasistenciales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbregistrodocumento`.`certificado_salud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbregistrodocumento`.`certificado_salud` (
  `idcertificado_salud` INT NOT NULL AUTO_INCREMENT,
  `idasistenciales` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `edad` VARCHAR(45) NOT NULL,
  `tipo_doc` VARCHAR(45) NOT NULL,
  `num_doc` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `serelogia` VARCHAR(45) NOT NULL,
  `examen_rx` VARCHAR(45) NOT NULL,
  `fecha_registro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcertificado_salud`),
  UNIQUE INDEX `num_doc_UNIQUE` (`num_doc` ASC),
  INDEX `fk_asistenciales_certificado_salud_idx` (`idasistenciales` ASC),
  CONSTRAINT `fk_asistenciales_certificado_salud`
    FOREIGN KEY (`idasistenciales`)
    REFERENCES `dbregistrodocumento`.`asistenciales` (`idasistenciales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
