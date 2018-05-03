drop database if exists heroes;
create database heroes;
use heroes;
create table extraterrestrial_hero (
 id int not null auto_increment primary key,
 name varchar(30),
 life int,
 power int,
 residence_planet varchar(30)
);
create table local_hero (
 id int not null auto_increment primary key,
 name varchar(30),
 life int,
 power int,
 residence_city varchar(30)
);
