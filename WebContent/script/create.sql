
drop schema `bd_notemaker`;
create schema if not exists `bd_notemaker`;
use `bd_notemaker`;
DROP TABLE IF exists `bd_notemaker`.`users`;
CREATE TABLE `bd_notemaker`.`users` (
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 `firstName` VARCHAR(45) NOT NULL ,
 `lastName` VARCHAR(45) NOT NULL ,
 `email` VARCHAR(45) NOT NULL ,
 `userId` VARCHAR(45) NOT NULL ,
 `password` VARCHAR(45) NOT NULL ,
 `role` VARCHAR(45) NOT NULL ,
 PRIMARY KEY(`id`) ) ; 
 
DROP TABLE IF EXISTS `bd_notemaker`.`note`;
CREATE TABLE `bd_notemaker`.`note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `content` varchar(512) NOT NULL,
  `published` date NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
  insert into users values(null, 'admin', 'admin', 'admin@gmail.com', 'admin','21232f297a57a5a743894a0e4a801fc3','ADMIN');