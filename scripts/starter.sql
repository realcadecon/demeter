CREATE DATABASE IF NOT EXISTS `demeter`;
USE `demeter`;

DROP TABLE IF EXISTS `food`;
DROP TABLE IF EXISTS `meal`;
DROP TABLE IF EXISTS `users_roles`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` char(80) DEFAULT NULL,
  `first_name`varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `user`(username, password, first_name, enabled) VALUES ('pres', '$2a$10$pzc3h7kh9fzqMEOqtfneH.CCMHAZCLUbt2euZEP3i3eprHw0S3TOq', 'Parker', 1);
INSERT INTO `user`(username, password, first_name, enabled) VALUES ('srut', '$2a$10$pzc3h7kh9fzqMEOqtfneH.CCMHAZCLUbt2euZEP3i3eprHw0S3TOq', 'Sydney', 1);


CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name) VALUES ('ROLE_USER'),('ROLE_ADMIN');


CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2);

CREATE TABLE `meal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT '',
  `calories-goal` int DEFAULT 0,
  `protein-goal` int DEFAULT 0,
  `carbs-goal` int DEFAULT 0,
  `fat-goal` int DEFAULT 0,
  `calories` int DEFAULT 0,
  `protein` int DEFAULT 0,
  `carbs` int DEFAULT 0,
  `fat` int DEFAULT 0,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `meal` (`name`, `user_id`) VALUES ('Breakfast', 1);
--
--  Food includes nutritional information, meal id, 
--    - food would be ideally pulled from USDA database and assigned to meals using a foreign key (meal id)
-- 

CREATE TABLE `food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `meal_id` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `calories` int DEFAULT NULL,
  `protein` int DEFAULT NULL,
  `carbs` int DEFAULT NULL,
  `fat` int DEFAULT NULL,
  `serving_size` varchar(45) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`meal_id`) REFERENCES `meal`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
