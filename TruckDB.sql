create database TruckDB;
use TruckDB;

create table truck
(
	id int primary key auto_increment,
    name varchar(30),
    model varchar(30),
    capacity int,
    driver_name varchar(30)
);

select * from truck;