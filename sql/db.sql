drop database heroes;
create database heroes;
use heroes;
create table hero (
  id int not null auto_increment primary key,
  name varchar(30),
  life int,
  power int,
  profile_id int not null
);
create table hero_profile (
  id int not null auto_increment primary key,
  phone_number varchar(15),
  gender varchar(6),
  birth_date datetime
);