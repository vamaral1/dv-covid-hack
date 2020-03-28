-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PandemicDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PandemicDB` ;

-- -----------------------------------------------------
-- Schema PandemicDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PandemicDB` DEFAULT CHARACTER SET utf8 ;
USE `PandemicDB` ;

-- -----------------------------------------------------
-- Table `facility`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility` ;

CREATE TABLE IF NOT EXISTS `facility` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `personal_protective_equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `personal_protective_equipment` ;

CREATE TABLE IF NOT EXISTS `personal_protective_equipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `powdered` TINYINT NULL,
  `size` ENUM('XS', 'S', 'M', 'L', 'XL') NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `hospital_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_hospital_idx` (`hospital_id` ASC),
  CONSTRAINT `fk_user_hospital`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility_inventory_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility_inventory_item` ;

CREATE TABLE IF NOT EXISTS `facility_inventory_item` (
  `facility_id` INT NOT NULL,
  `ppe_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`facility_id`, `ppe_id`),
  INDEX `fk_hospital_has_inventory_item_inventory_item1_idx` (`ppe_id` ASC),
  INDEX `fk_hospital_has_inventory_item_hospital1_idx` (`facility_id` ASC),
  CONSTRAINT `fk_hospital_has_inventory_item_hospital1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospital_has_inventory_item_inventory_item1`
    FOREIGN KEY (`ppe_id`)
    REFERENCES `personal_protective_equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cleaning_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cleaning_product` ;

CREATE TABLE IF NOT EXISTS `cleaning_product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `agent` VARCHAR(45) NULL,
  `concentration` DOUBLE NULL,
  `name` VARCHAR(45) NULL,
  `volume` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility_cleaning_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility_cleaning_product` ;

CREATE TABLE IF NOT EXISTS `facility_cleaning_product` (
  `facility_cleaning_product_id` INT NOT NULL,
  `cleaning_product_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`facility_cleaning_product_id`, `cleaning_product_id`),
  INDEX `fk_hospital_has_cleaning_product_cleaning_product1_idx` (`cleaning_product_id` ASC),
  INDEX `fk_hospital_has_cleaning_product_hospital1_idx` (`facility_cleaning_product_id` ASC),
  CONSTRAINT `fk_hospital_has_cleaning_product_hospital1`
    FOREIGN KEY (`facility_cleaning_product_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospital_has_cleaning_product_cleaning_product1`
    FOREIGN KEY (`cleaning_product_id`)
    REFERENCES `cleaning_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mask`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mask` ;

CREATE TABLE IF NOT EXISTS `mask` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `rating` VARCHAR(45) NULL,
  `reusable` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bed` ;

CREATE TABLE IF NOT EXISTS `bed` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `icu` TINYINT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility_mask`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility_mask` ;

CREATE TABLE IF NOT EXISTS `facility_mask` (
  `facility_id` INT NOT NULL,
  `mask_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`facility_id`, `mask_id`),
  INDEX `fk_hospital_has_mask_mask1_idx` (`mask_id` ASC),
  INDEX `fk_hospital_has_mask_hospital1_idx` (`facility_id` ASC),
  CONSTRAINT `fk_hospital_has_mask_hospital1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospital_has_mask_mask1`
    FOREIGN KEY (`mask_id`)
    REFERENCES `mask` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility_bed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility_bed` ;

CREATE TABLE IF NOT EXISTS `facility_bed` (
  `hospital_id` INT NOT NULL,
  `bed_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`hospital_id`, `bed_id`),
  INDEX `fk_hospital_has_bed_bed1_idx` (`bed_id` ASC),
  INDEX `fk_hospital_has_bed_hospital1_idx` (`hospital_id` ASC),
  CONSTRAINT `fk_hospital_has_bed_hospital1`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospital_has_bed_bed1`
    FOREIGN KEY (`bed_id`)
    REFERENCES `bed` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `room` ;

CREATE TABLE IF NOT EXISTS `room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `icu` TINYINT NULL,
  `negative_pressure` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `test` ;

CREATE TABLE IF NOT EXISTS `test` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility_test`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility_test` ;

CREATE TABLE IF NOT EXISTS `facility_test` (
  `facility_id` INT NOT NULL,
  `test_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`facility_id`, `test_id`),
  INDEX `fk_test_has_hospital_hospital1_idx` (`facility_id` ASC),
  INDEX `fk_test_has_hospital_test1_idx` (`test_id` ASC),
  CONSTRAINT `fk_test_has_hospital_test1`
    FOREIGN KEY (`test_id`)
    REFERENCES `test` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_has_hospital_hospital1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ventilator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ventilator` ;

CREATE TABLE IF NOT EXISTS `ventilator` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `invasive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility_room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility_room` ;

CREATE TABLE IF NOT EXISTS `facility_room` (
  `facility_id` INT NOT NULL,
  `room_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`facility_id`, `room_id`),
  INDEX `fk_hospital_has_room_room1_idx` (`room_id` ASC),
  INDEX `fk_hospital_has_room_hospital1_idx` (`facility_id` ASC),
  CONSTRAINT `fk_hospital_has_room_hospital1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospital_has_room_room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facility_ventilator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facility_ventilator` ;

CREATE TABLE IF NOT EXISTS `facility_ventilator` (
  `facility_id` INT NOT NULL,
  `ventilator_id` INT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`facility_id`, `ventilator_id`),
  INDEX `fk_hospital_has_ventilator_ventilator1_idx` (`ventilator_id` ASC),
  INDEX `fk_hospital_has_ventilator_hospital1_idx` (`facility_id` ASC),
  CONSTRAINT `fk_hospital_has_ventilator_hospital1`
    FOREIGN KEY (`facility_id`)
    REFERENCES `facility` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospital_has_ventilator_ventilator1`
    FOREIGN KEY (`ventilator_id`)
    REFERENCES `ventilator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  `phone` VARCHAR(45) NULL,
  `postal_code` VARCHAR(45) NULL,
  `state_province` VARCHAR(45) NULL,
  `street` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS pandemicuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'pandemicuser'@'localhost' IDENTIFIED BY 'pandemicuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'pandemicuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
