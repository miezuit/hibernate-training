drop database if exists heroes;
create database heroes;
use heroes;
create table hero (
  id int not null auto_increment primary key,
  name varchar(30),
  life int,
  power int
);
create table nicknames (
   hero_id int not null primary key,
   nickname varchar(30)
);