-- MySQL Script generated by MySQL Workbench
-- Mon Nov 25 21:39:54 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`producer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`producer` ;

CREATE TABLE IF NOT EXISTS `mydb`.`producer` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(50) NOT NULL,
                                                 `phone` VARCHAR(50) NULL,
                                                 `address` VARCHAR(50) NULL,
                                                 PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`product` ;

CREATE TABLE IF NOT EXISTS `mydb`.`product` (
                                                `id` INT NOT NULL AUTO_INCREMENT,
                                                `producerId` INT NOT NULL,
                                                `name` VARCHAR(50) NOT NULL,
                                                `quantity` INT NOT NULL,
                                                `price` DOUBLE NOT NULL,
                                                `priceNDS` DOUBLE NOT NULL,
                                                PRIMARY KEY (`id`),
                                                INDEX `fk_товар_изготовитель1_idx` (`producerId` ASC),
                                                CONSTRAINT `fk_товар_изготовитель1`
                                                    FOREIGN KEY (`producerId`)
                                                        REFERENCES `mydb`.`producer` (`id`)
                                                        ON DELETE CASCADE
                                                        ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`consumer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`consumer` ;

CREATE TABLE IF NOT EXISTS `mydb`.`consumer` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(60) NOT NULL,
                                                 `phone` VARCHAR(50) NULL,
                                                 `address` VARCHAR(50) NULL,
                                                 PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`bill` ;

CREATE TABLE IF NOT EXISTS `mydb`.`bill` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `productId` INT NOT NULL,
                                             `consumerId` INT NOT NULL,
                                             `date` DATE NOT NULL,
                                             `quantity` INT NOT NULL,
                                             `total` DOUBLE NOT NULL,
                                             `totalNDS` DOUBLE NOT NULL,
                                             PRIMARY KEY (`id`),
                                             INDEX `fk_счет_товар1_idx` (`productId` ASC),
                                             INDEX `fk_счет_производитель1_idx` (`consumerId` ASC),
                                             CONSTRAINT `fk_счет_товар1`
                                                 FOREIGN KEY (`productId`)
                                                     REFERENCES `mydb`.`product` (`id`)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION,
                                             CONSTRAINT `fk_счет_производитель1`
                                                 FOREIGN KEY (`consumerId`)
                                                     REFERENCES `mydb`.`consumer` (`id`)
                                                     ON DELETE CASCADE
                                                     ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`earnings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`earnings` ;

CREATE TABLE IF NOT EXISTS `mydb`.`earnings` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `productId` INT NOT NULL,
                                                 `date` DATE NOT NULL,
                                                 `quantity` DOUBLE NOT NULL,
                                                 PRIMARY KEY (`id`),
                                                 INDEX `fk_earnings_product1_idx` (`productId` ASC),
                                                 CONSTRAINT `fk_earnings_product1`
                                                     FOREIGN KEY (`productId`)
                                                         REFERENCES `mydb`.`product` (`id`)
                                                         ON DELETE CASCADE
                                                         ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`stock` ;

CREATE TABLE IF NOT EXISTS `mydb`.`stock` (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `date` DATE NOT NULL,
                                              `quantity` INT NOT NULL,
                                              PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`incoming`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`incoming` ;

CREATE TABLE IF NOT EXISTS `mydb`.`incoming` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `productId` INT NOT NULL,
                                                 `date` DATE NOT NULL,
                                                 `quantity` INT NOT NULL,
                                                 PRIMARY KEY (`id`),
                                                 INDEX `fk_приходная накладная_товар1_idx` (`productId` ASC),
                                                 CONSTRAINT `fk_приходная накладная_товар1`
                                                     FOREIGN KEY (`productId`)
                                                         REFERENCES `mydb`.`product` (`id`)
                                                         ON DELETE CASCADE
                                                         ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`transport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`transport` ;

CREATE TABLE IF NOT EXISTS `mydb`.`transport` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `date` DATE NOT NULL,
                                                  `total` DOUBLE NOT NULL,
                                                  `totalNDS` DOUBLE NOT NULL,
                                                  PRIMARY KEY (`id`))
    ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `username` VARCHAR(45) NOT NULL,
                                             `password` VARCHAR(45) NOT NULL,
                                             `role` VARCHAR(45) NOT NULL,
                                             `r` VARCHAR(45) NOT NULL,
                                             PRIMARY KEY (`id`))
    ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`user` (`id`, `username`, `password`, `role`,`r`) VALUES (1, 'manager', '1111', 'manager','менеджер');
INSERT INTO `mydb`.`user` (`id`, `username`, `password`, `role`,`r`) VALUES (2, 'stockManager', '2222', 'stockManager','менеджер склада');
INSERT INTO `mydb`.`user` (`id`, `username`, `password`, `role`,`r`) VALUES (3, 'accountant', '3333', 'accountant','бухгалтер');
COMMIT;