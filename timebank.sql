-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema timebankdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `timebankdb` ;

-- -----------------------------------------------------
-- Schema timebankdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `timebankdb` DEFAULT CHARACTER SET utf8 ;
USE `timebankdb` ;

-- -----------------------------------------------------
-- Table `user_account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_account` ;

CREATE TABLE IF NOT EXISTS `user_account` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `address_id` INT UNSIGNED NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `password_salt` VARCHAR(50) NULL,
  `password_hash` VARCHAR(50) NOT NULL,
  `admin_comment` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `user_account` (`id` ASC);


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `category` (`id` ASC);


-- -----------------------------------------------------
-- Table `subcategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `subcategory` ;

CREATE TABLE IF NOT EXISTS `subcategory` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `category_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(100) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_subcategory_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `subcategory` (`id` ASC);

CREATE INDEX `fk_subcategory_category_id_idx` ON `subcategory` (`category_id` ASC);


-- -----------------------------------------------------
-- Table `offer_date`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `offer_date` ;

CREATE TABLE IF NOT EXISTS `offer_date` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `offer_id` INT UNSIGNED NOT NULL,
  `offer_begin_date` DATE NOT NULL,
  `offer_begin_time` TIME NULL,
  `offer_end_date` DATE NULL,
  `offer_end_time` TIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_offer_recur_date_offer_id`
    FOREIGN KEY (`offer_id`)
    REFERENCES `offer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `offer_date` (`id` ASC);

CREATE INDEX `fk_offer_recur_date_offer_id_idx` ON `offer_date` (`offer_id` ASC);


-- -----------------------------------------------------
-- Table `offer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `offer` ;

CREATE TABLE IF NOT EXISTS `offer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `category_id` INT UNSIGNED NOT NULL,
  `subcategory_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `description` TEXT NOT NULL,
  `offer_date_id` INT UNSIGNED NOT NULL,
  `create_date` DATE NOT NULL,
  `last_update` TIMESTAMP(0) NULL,
  `last_update_user_id` INT UNSIGNED NULL,
  `admin_comment` TEXT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_offer_user_id_user_account_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_offer_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_offer_subcategory_id`
    FOREIGN KEY (`subcategory_id`)
    REFERENCES `subcategory` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_offer_offer_date_id`
    FOREIGN KEY (`offer_date_id`)
    REFERENCES `offer_date` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_offer_last_update_user_user_account_id`
    FOREIGN KEY (`last_update_user_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `offer` (`id` ASC);

CREATE INDEX `fk_offer_user_account_id_idx` ON `offer` (`user_id` ASC);

CREATE INDEX `fk_offer_category_id_idx` ON `offer` (`category_id` ASC);

CREATE INDEX `fk_offer_subcategory_id_idx` ON `offer` (`subcategory_id` ASC);

CREATE INDEX `fk_offer_offer_date_id_idx` ON `offer` (`offer_date_id` ASC);

CREATE INDEX `fk_offer_last_update_user_user_account_id_idx` ON `offer` (`last_update_user_id` ASC);


-- -----------------------------------------------------
-- Table `request_date`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `request_date` ;

CREATE TABLE IF NOT EXISTS `request_date` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `request_id` INT UNSIGNED NOT NULL,
  `request_begin_date` DATE NOT NULL,
  `request_begin_time` TIME NULL,
  `request_end_date` DATE NULL,
  `request_end_time` TIME NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_request_recur_date_request_id`
    FOREIGN KEY (`request_id`)
    REFERENCES `request` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `request_date` (`id` ASC);

CREATE INDEX `fk_request_recur_date_request_id_idx` ON `request_date` (`request_id` ASC);


-- -----------------------------------------------------
-- Table `request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `request` ;

CREATE TABLE IF NOT EXISTS `request` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `category_id` INT UNSIGNED NOT NULL,
  `subcategory_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `description` TEXT NOT NULL,
  `request_date_id` INT UNSIGNED NOT NULL,
  `create_date` DATE NOT NULL,
  `last_update` TIMESTAMP(0) NULL,
  `last_update_user_id` INT UNSIGNED NULL,
  `admin_comment` TEXT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_request_user_id_user_account`
    FOREIGN KEY (`user_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_request_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_request_subcategory_id`
    FOREIGN KEY (`subcategory_id`)
    REFERENCES `subcategory` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_request_request_date_id`
    FOREIGN KEY (`request_date_id`)
    REFERENCES `request_date` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_request_last_update_user_user_account_id`
    FOREIGN KEY (`last_update_user_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_request_user_account_idx` ON `request` (`user_id` ASC);

CREATE UNIQUE INDEX `id_UNIQUE` ON `request` (`id` ASC);

CREATE INDEX `fk_request_category_id_idx` ON `request` (`category_id` ASC);

CREATE INDEX `fk_request_subcategory_id_idx` ON `request` (`subcategory_id` ASC);

CREATE INDEX `fk_request_request_date_id_idx` ON `request` (`request_date_id` ASC);

CREATE INDEX `fk_request_last_update_user_user_account_id_idx` ON `request` (`last_update_user_id` ASC);


-- -----------------------------------------------------
-- Table `offer_tx`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `offer_tx` ;

CREATE TABLE IF NOT EXISTS `offer_tx` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `offer_id` INT UNSIGNED NOT NULL,
  `received` TINYINT(1) NOT NULL DEFAULT 0,
  `recipient_user_id` INT UNSIGNED NOT NULL,
  `received_timestamp` TIMESTAMP(0) NULL,
  `complete` TINYINT(1) NOT NULL DEFAULT 0,
  `complete_timestamp` TIMESTAMP(0) NULL,
  `closed` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '\n',
  `last_update` TIMESTAMP(0) NULL,
  `last_update_id` INT NULL,
  `admin_comment` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `offer_tx` (`id` ASC);


-- -----------------------------------------------------
-- Table `request_tx`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `request_tx` ;

CREATE TABLE IF NOT EXISTS `request_tx` (
  `id` INT NOT NULL,
  `request_id` INT NOT NULL,
  `accepted` TINYINT(1) NULL,
  `accepting_user_id` INT NULL,
  `accept_timestamp` TIMESTAMP(0) NULL,
  `complete` TINYINT(1) NULL,
  `complete_timestamp` TIMESTAMP(0) NULL,
  `last_update` TIMESTAMP(0) NULL,
  `closed` TINYINT(1) NULL,
  `last_update_id` INT NULL,
  `admin_comment` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(100) NULL,
  `street_2` VARCHAR(100) NULL,
  `city` VARCHAR(100) NULL,
  `state` VARCHAR(100) NULL,
  `zip` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `address` (`id` ASC);


-- -----------------------------------------------------
-- Table `timebank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `timebank` ;

CREATE TABLE IF NOT EXISTS `timebank` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `timebank` (`id` ASC);


-- -----------------------------------------------------
-- Table `timebank_admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `timebank_admin` ;

CREATE TABLE IF NOT EXISTS `timebank_admin` (
  `admin_id` INT UNSIGNED NOT NULL,
  `timebank_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`admin_id`, `timebank_id`),
  CONSTRAINT `fk_timebank_admin_user_account_id`
    FOREIGN KEY (`admin_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_timebank_admin_timebank`
    FOREIGN KEY (`timebank_id`)
    REFERENCES `timebank` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `timebank_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `timebank_user` ;

CREATE TABLE IF NOT EXISTS `timebank_user` (
  `user_id` INT UNSIGNED NOT NULL,
  `timebank_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`user_id`, `timebank_id`),
  CONSTRAINT `fk_timebank_user_user_account_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_timebank_user_timebank_id`
    FOREIGN KEY (`timebank_id`)
    REFERENCES `timebank` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_timebank_user_timebank_id_idx` ON `timebank_user` (`timebank_id` ASC);


-- -----------------------------------------------------
-- Table `talent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `talent` ;

CREATE TABLE IF NOT EXISTS `talent` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `subcategory_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `description` TEXT NOT NULL,
  `create_date` DATE NOT NULL,
  `last_update` TIMESTAMP(0) NULL,
  `expires` TINYINT(1) NULL,
  `expiry_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `talent` (`id` ASC);


-- -----------------------------------------------------
-- Table `user_hours`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_hours` ;

CREATE TABLE IF NOT EXISTS `user_hours` (
  `user_id` INT UNSIGNED NOT NULL,
  `timebank_id` INT UNSIGNED NOT NULL,
  `hours` INT NOT NULL,
  PRIMARY KEY (`user_id`, `timebank_id`),
  CONSTRAINT `fk_user_hours_user_account_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user_account` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_hours_timebank_id`
    FOREIGN KEY (`timebank_id`)
    REFERENCES `timebank` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_user_hours_timebank_id_idx` ON `user_hours` (`timebank_id` ASC);

SET SQL_MODE = '';
GRANT USAGE ON *.* TO timebank@localhost;
 DROP USER timebank@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'timebank'@'localhost' IDENTIFIED BY 'timebank';

GRANT SELECT ON TABLE * TO 'timebank'@'localhost';
GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'timebank'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'timebank'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
