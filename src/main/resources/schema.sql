DROP TABLE IF EXISTS dishMaster;
create table dishMaster
(
dishId INTEGER not null,
name varchar(255) not null,
mealTimes varchar(255),
dishType varchar(255),
primary key (dishId)
);