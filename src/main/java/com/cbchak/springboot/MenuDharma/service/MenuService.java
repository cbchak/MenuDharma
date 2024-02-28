package com.cbchak.springboot.MenuDharma.service;

import com.cbchak.springboot.MenuDharma.domain.dishes;
import com.cbchak.springboot.MenuDharma.domain.sideDishes;
import com.cbchak.springboot.MenuDharma.repository.dishInterface;
import com.cbchak.springboot.MenuDharma.repository.scheduleInterface;
import com.cbchak.springboot.MenuDharma.repository.sideDishesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class MenuService {
    @Autowired
    private dishInterface dishRepo;
    @Autowired
    private scheduleInterface scheduleRepo;
    @Autowired
    private sideDishesInterface sideDishRepo;

    public dishes findDish(String mealTime, LocalDate menuDate){
        List<dishes> eligDishes =  dishRepo.findByMealTime(mealTime);

        dishes chosenDish = new dishes();

        long daysSince = 0;

        for (dishes d : eligDishes){
            long daysSinceD = 0;
            switch (mealTime) {
                case "breakfast" ->
                        daysSinceD = DAYS.between(
                               defaultDate(scheduleRepo.findLastMadeDateBreakfast(d.getDishId()))
                                , menuDate);
                case "lunch" ->
                        daysSinceD = DAYS.between(
                               defaultDate(scheduleRepo.findLastMadeDateLunch(d.getDishId()))
                                , menuDate);
            }

            if (daysSinceD > daysSince){
                chosenDish = d;
                daysSince = daysSinceD;
            }

        }
        return chosenDish;
    }

    public sideDishes findSide(dishes dish, String mealTime, LocalDate menuDate){
        List<sideDishes> eligSides =  sideDishRepo.findByGoesWith(dish.getDishId());
        sideDishes chosenSide = new sideDishes();

        long daysSince = 0;

        for (sideDishes d : eligSides){
            long daysSinceD = 0;
            switch (mealTime) {
                case "breakfast" ->
                        daysSinceD = DAYS.between(
                               defaultDate(scheduleRepo.findLastMadeDateBreakfastSide(d.getSideId()))
                                ,menuDate);
                case "lunch" ->
                        daysSinceD = DAYS.between(
                               defaultDate(scheduleRepo.findLastMadeDateLunchSide(d.getSideId()))
                                ,menuDate);
            }
            if (daysSinceD > daysSince){
                chosenSide = d;
                daysSince = daysSinceD;
            }
            else continue;
        }
        return chosenSide;
    }

    private static LocalDate defaultDate(LocalDate date){
        if(date!=null) {
            return date;
        }
        else return LocalDate.now().minusYears(2);
    }



}
