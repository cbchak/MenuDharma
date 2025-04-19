DROP TABLE IF EXISTS dishMaster;
create table dishMaster
(
dishId INTEGER not null,
name varchar(255) not null,
mealTime varchar(255),
containsRice boolean,
needSide boolean,
primary key (dishId)
);