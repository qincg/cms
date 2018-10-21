create database cms;
use cms;
create table user(
  id int auto_increment primary key not null ,
  userName varchar(10) not null,
  gender varchar(5),
  gj varchar(10)
);
