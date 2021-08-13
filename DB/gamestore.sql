-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gamestoredb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gamestoredb` ;

-- -----------------------------------------------------
-- Schema gamestoredb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gamestoredb` DEFAULT CHARACTER SET utf8 ;
USE `gamestoredb` ;

-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NULL,
  `platform` VARCHAR(30) NOT NULL,
  `release_year` INT NULL,
  `price` INT NULL,
  `condition_game` VARCHAR(10) NOT NULL DEFAULT 'NEW',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS storeuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'storeuser'@'localhost' IDENTIFIED BY 'storeuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'storeuser'@'localhost';
GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'storeuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `game`
-- -----------------------------------------------------
START TRANSACTION;
USE `gamestoredb`;
INSERT INTO `game` (`id`, `title`, `description`, `platform`, `release_year`, `price`, `condition_game`) VALUES (1, 'Super Mario 64', 'Mario takes an Adventure to save Princess Peach!', 'Nintendo', 1995, 40, 'NEW');
INSERT INTO `game` (`id`, `title`, `description`, `platform`, `release_year`, `price`, `condition_game`) VALUES (2, 'Cyberpunk 2077', 'Explore Night City in this dystopian future where technology controls society.', 'PC', 2020, 60, 'PRE-OWNED');
INSERT INTO `game` (`id`, `title`, `description`, `platform`, `release_year`, `price`, `condition_game`) VALUES (3, 'Halo', 'As a Spartan Warrior for UNSC, you are the sole hope for Humanity as you battle the Convenant in this fierce futuristic FPS.', 'Xbox', 2001, 30, 'PRE-OWNED');
INSERT INTO `game` (`id`, `title`, `description`, `platform`, `release_year`, `price`, `condition_game`) VALUES (4, 'World of Warcraft', 'Explore Azeroth as your very own Hero, choosing from 2 Factions each with 5 unique races. Play with friends or solo, the World is yours to explore and conquer!', 'PC', 2003, 60, 'NEW');
INSERT INTO `game` (`id`, `title`, `description`, `platform`, `release_year`, `price`, `condition_game`) VALUES (5, 'Resident Evil', 'A special mission leads the S.T.A.R.S Team to a remote Mansion where the story of a biohazard outbreak unfolds. A must for any fans of Horror!', 'Playstation', 2000, 30, 'PRE-OWNED');

COMMIT;

