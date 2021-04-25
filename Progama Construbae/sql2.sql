-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Proyecto` (
  `idProyecto` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NOT NULL,
  `comuna` VARCHAR(45) NOT NULL,
  `adjudicado` VARCHAR(45) NOT NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idProyecto`, `Empresa_idEmpresa`),
  INDEX `fk_Proyecto_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  CONSTRAINT `fk_Proyecto_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `mydb`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Gasto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Gasto` (
  `idGasto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `total` INT NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idGasto`, `Empresa_idEmpresa`),
  INDEX `fk_Gasto_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  CONSTRAINT `fk_Gasto_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `mydb`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Inventario` (
  `idInventario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `caracteristica` VARCHAR(45) NOT NULL,
  `Cantidad` INT NOT NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  `Gasto_idGasto` INT NOT NULL,
  PRIMARY KEY (`idInventario`, `Empresa_idEmpresa`, `Gasto_idGasto`),
  INDEX `fk_Inventario_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  INDEX `fk_Inventario_Gasto1_idx` (`Gasto_idGasto` ASC) VISIBLE,
  CONSTRAINT `fk_Inventario_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `mydb`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inventario_Gasto1`
    FOREIGN KEY (`Gasto_idGasto`)
    REFERENCES `mydb`.`Gasto` (`idGasto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `Empresa_idEmpresa`),
  INDEX `fk_Usuario_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  CONSTRAINT `fk_Usuario_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `mydb`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Personal` (
  `idPersonal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `sueldo` INT NULL,
  `Empresa_idEmpresa` INT NOT NULL,
  PRIMARY KEY (`idPersonal`, `Empresa_idEmpresa`),
  INDEX `fk_Personal_Empresa1_idx` (`Empresa_idEmpresa` ASC),
  CONSTRAINT `fk_Personal_Empresa1`
    FOREIGN KEY (`Empresa_idEmpresa`)
    REFERENCES `mydb`.`Empresa` (`idEmpresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`GastoProyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`GastoProyecto` (
  `idGastoProyecto` INT NOT NULL AUTO_INCREMENT,
  `nomProyecto` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `caracteristica` VARCHAR(45) NOT NULL,
  `cantidad` INT NOT NULL,
  `Inventario_idInventario` INT NOT NULL,
  `Inventario_Empresa_idEmpresa` INT NOT NULL,
  `Inventario_Gasto_idGasto` INT NOT NULL,
  PRIMARY KEY (`idGastoProyecto`, `Inventario_idInventario`, `Inventario_Empresa_idEmpresa`, `Inventario_Gasto_idGasto`),
  INDEX `fk_GastoProyecto_Inventario1_idx` (`Inventario_idInventario` ASC, `Inventario_Empresa_idEmpresa` ASC, `Inventario_Gasto_idGasto` ASC)
  CONSTRAINT `fk_GastoProyecto_Inventario1`
    FOREIGN KEY (`Inventario_idInventario` , `Inventario_Empresa_idEmpresa` , `Inventario_Gasto_idGasto`)
    REFERENCES `mydb`.`Inventario` (`idInventario` , `Empresa_idEmpresa` , `Gasto_idGasto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;