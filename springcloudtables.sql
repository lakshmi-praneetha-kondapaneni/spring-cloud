create database mydb;

use mydb;
create table product(
id int auto_increment,
name varchar(20),
description varchar(100),
price decimal(8,3),
primary key(id)
);
create table coupon(
id int auto_increment,
code varchar(20),
discount decimal(8,3),
exp_date varchar(100),
primary key(id)
);
select * from product;
select * from coupon;
TRUNCATE TABLE coupon;
use mydb;
create table ticket(
id int auto_increment,
name varchar(50),
no_of_tickets int,
source varchar(20),
destination VARCHAR(20),
ticket_code varchar(20),
price decimal(9,3),
primary key(id)
);