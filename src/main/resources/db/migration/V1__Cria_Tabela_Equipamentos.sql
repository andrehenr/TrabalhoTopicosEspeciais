CREATE TABLE `equipamento`.`equipamentos` ( 
`id` INT NOT NULL AUTO_INCREMENT , 
`nome` VARCHAR(60) NOT NULL ,
`tipo` VARCHAR(60) NOT NULL ,
`peso` DOUBLE(10,2) NOT NULL , 
PRIMARY KEY (`id`)) ENGINE = InnoDB;