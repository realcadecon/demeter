CREATE DATABASE IF NOT EXISTS `demeter-test`;
USE `demeter-test`;

DROP TABLE IF EXISTS `food`;
DROP TABLE IF EXISTS `meal`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `first_name`varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `meal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
--  Food includes nutritional information, meal id,
--    - food would be ideally pulled from USDA database and assigned to meals using a foreign key (meal id)
--

CREATE TABLE `food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `meal_id` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `calories` int DEFAULT NULL,
  `serving_size` varchar(45) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`meal_id`) REFERENCES `meal`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;