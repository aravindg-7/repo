-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema online_blood_bank_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema online_blood_bank_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_blood_bank_system` DEFAULT CHARACTER SET utf8 ;
USE `online_blood_bank_system` ;

-- -----------------------------------------------------
-- Table `online_blood_bank_system`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank_system`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_user_name` VARCHAR(50) NULL DEFAULT NULL,
  `us_first_name` VARCHAR(50) NULL DEFAULT NULL,
  `us_last_name` VARCHAR(50) NULL DEFAULT NULL,
  `us_age` INT(3) NULL DEFAULT NULL,
  `us_gender` VARCHAR(10) NULL DEFAULT NULL,
  `us_contact_number` VARCHAR(10) NULL DEFAULT NULL,
  `us_email` VARCHAR(50) NOT NULL,
  `us_password` VARCHAR(70) NULL DEFAULT NULL,
  `us_weight` INT(5) NULL DEFAULT NULL,
  `us_state` VARCHAR(50) NULL DEFAULT NULL,
  `us_area` VARCHAR(50) NULL DEFAULT NULL,
  `us_pincode` INT(6) NULL DEFAULT NULL,
  `us_blood_group` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  UNIQUE INDEX `us_email` (`us_email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank_system`.`blood_request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank_system`.`blood_request` (
  `req_us_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `req_us_blood_group` VARCHAR(5) NOT NULL,
  `req_us_state` VARCHAR(50) NOT NULL,
  `req_us_area` VARCHAR(50) NOT NULL,
  `req_us_pin_code` INT(6) NOT NULL,
  `req_us_contact_number` VARCHAR(10) NOT NULL,
  `req_us_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`req_us_id`),
  INDEX `req_us_id_fk` (`req_us_id_fk` ASC),
  CONSTRAINT `blood_request_ibfk_1`
    FOREIGN KEY (`req_us_id_fk`)
    REFERENCES `online_blood_bank_system`.`user` (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank_system`.`donor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank_system`.`donor` (
  `do_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `do_blood_group` VARCHAR(45) NOT NULL,
  `do_state` VARCHAR(45) NOT NULL,
  `do_area` VARCHAR(45) NOT NULL,
  `do_pin_code` INT(6) NOT NULL,
  `do_contact_number` VARCHAR(10) NOT NULL,
  `do_us_id` INT(11) NOT NULL,
  PRIMARY KEY (`do_id`),
  INDEX `fk_donor_user1_idx` (`do_us_id` ASC),
  CONSTRAINT `fk_donor_user1`
    FOREIGN KEY (`do_us_id`)
    REFERENCES `online_blood_bank_system`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 48
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank_system`.`hospital_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank_system`.`hospital_booking` (
  `hb_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `hb_name` VARCHAR(15) NOT NULL,
  `hb_city` VARCHAR(15) NOT NULL,
  `hb_time` VARCHAR(15) NOT NULL,
  `hb_date` DATE NOT NULL,
  `hb_do_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`hb_id`),
  INDEX `fk_hospital_booking_donor1_idx` (`hb_do_id` ASC),
  CONSTRAINT `fk_hospital_booking_donor1`
    FOREIGN KEY (`hb_do_id`)
    REFERENCES `online_blood_bank_system`.`donor` (`do_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank_system`.`hospital_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank_system`.`hospital_feedback` (
  `hf_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `hf_name` VARCHAR(15) NOT NULL,
  `hf_city` VARCHAR(15) NOT NULL,
  `hf_feedback` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`hf_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank_system`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank_system`.`role` (
  `ro_id` INT(11) NOT NULL,
  `ro_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank_system`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank_system`.`user_role` (
  `ur_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT(11) NOT NULL,
  `ur_ro_id` INT(11) NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `fk_user_role_user_idx` (`ur_us_id` ASC),
  INDEX `fk_user_role_role1_idx` (`ur_ro_id` ASC),
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `online_blood_bank_system`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `online_blood_bank_system`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
