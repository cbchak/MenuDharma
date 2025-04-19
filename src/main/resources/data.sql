INSERT INTO dishMaster (dishId,name,mealTime,containsRice,needSide)
select * from CSVREAD('classpath:dishMaster.csv');