drop database if exists heroes;
create database heroes;
use heroes;
CREATE TABLE `hero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `life` int(11) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
CREATE TABLE `villain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `life` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
CREATE TABLE `enemies` (
  `hero_id` int(11) NOT NULL,
  `villain_id` int(11) NOT NULL,
  PRIMARY KEY (`hero_id`,`villain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;