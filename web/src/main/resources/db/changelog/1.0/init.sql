-- liquibase formatted sql
-- changeset Fiodar Karnilovich:1
-- comment default character encoding
ALTER SCHEMA `rentalcar_db` DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

-- changeset Fiodar Karnilovich:2
CREATE TABLE IF NOT EXISTS `rentalcar_db`.`userRole` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    `roleName` VARCHAR(50) NOT NULL)

-- changeset Fiodar Karnilovich:3
CREATE TABLE IF NOT EXISTS `rentalcar_db`.`autoBrand` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    `brandName` VARCHAR(50) NOT NULL)

-- changeset Fiodar Karnilovich:4
CREATE TABLE IF NOT EXISTS `rentalcar_db`.`autoModel` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `brandName_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    `modelName` VARCHAR(50) NOT NULL,
    CONSTRAINT `fk_brandName_id`
    FOREIGN KEY (`brandName_id`)
    REFERENCES `rentalcar_db`.`autoBrand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

-- changeset Fiodar Karnilovich:5
CREATE TABLE IF NOT EXISTS `rentalcar_db`.`auto` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    `modelName_id` INT(11) NOT NULL,
    CONSTRAINT `fk_modelName_id`
    FOREIGN KEY (`modelName_id`)
    REFERENCES `rentalcar_db`.`autoModel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    `autoModel` VARCHAR(50) NOT NULL,
    `colourAuto` VARCHAR(50) NOT NULL,
    `transmissionAuto` VARCHAR(50) NOT NULL,
    `yearAuto` INT(11) NOT NULL,
    `priceAuto` DECIMAL(11,2) NOT NULL)


-- changeset Fiodar Karnilovich:6
CREATE TABLE IF NOT EXISTS `rentalcar_db`.`autoPicture` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    `auto_id` INT(11) NOT NULL,
    `picture` BINARY NOT NULL,
    CONSTRAINT `fk_auto_id`
    FOREIGN KEY (`auto_id`)
    REFERENCES `rentalcar_db`.`auto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)

-- changeset Fiodar Karnilovich:7
CREATE TABLE IF NOT EXISTS `rentalcar_db`.`person` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    `firstName` VARCHAR(50) NOT NULL,
    `lastName` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `birthDay` DATE NULL DEFAULT NULL,
    `phoneNumber` VARCHAR(50) NOT NULL,
    `userRole_id` INT(11) NOT NULL,
    CONSTRAINT `fk_user_role`
    FOREIGN KEY (`userRole_id`)
    REFERENCES `rentalcar_db`.`userRole` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

-- changeset Fiodar Karnilovich:8
CREATE TABLE IF NOT EXISTS `rentalcar_db`.`carOrder` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    `person_id` INT(11) NOT NULL,
    CONSTRAINT `fk_person_id`
    FOREIGN KEY (`person_id`)
    REFERENCES `rentalcar_db`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    `auto_id` INT(11) NOT NULL,
    CONSTRAINT `fk_car_order_auto`
    FOREIGN KEY (`auto_id`)
    REFERENCES `rentalcar_db`.`auto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    `dateStart`  VARCHAR(50) NOT NULL,
    `dateFinish`  VARCHAR(50) NOT NULL)