INSERT INTO dishMaster (dishId,name,mealTimes,dishType)
select * from CSVREAD('classpath:dishMaster.csv');