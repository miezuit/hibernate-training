drop database if exists heroes;
create database heroes;
use heroes;
create table hero (
  id int not null auto_increment primary key,
  name varchar(30) not null,
  life int,
  power int,
  type varchar(10),
  residence_planet varchar(30),
  residence_city varchar(30)
);
