package com.cbchak.springboot.MenuDharma.service;

import com.cbchak.springboot.MenuDharma.domain.DayMenu;
import com.cbchak.springboot.MenuDharma.domain.Schedule;
import com.cbchak.springboot.MenuDharma.repository.scheduleInterface;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private scheduleInterface scheduleRepo;
    @Autowired
    private MenuService menuService;

    public void setScheduleForWeek(LocalDate date){
        DayOfWeek weekStart = DayOfWeek.SUNDAY;
        date = date.with(TemporalAdjusters.previousOrSame(weekStart));
        for(int i = 0; i<=6; i++){
            LocalDate menuDate = date.plusDays(i);
            DayMenu dayMenu = new DayMenu();
            setMenuForDate(menuDate, dayMenu);
            scheduleRepo.save(MenuToSchedule(dayMenu));
        }
    }

    public void setMenuForDate(LocalDate menuDate, DayMenu dayMenu){
        dayMenu.setMenuDate(menuDate);
        dayMenu.setBreakFast(menuService.findDish("breakfast",menuDate));
        dayMenu.setBreakFastSide(menuService.findSide(dayMenu.getBreakFast() ,"breakfast",menuDate));
        dayMenu.setLunch(menuService.findDish("lunch",menuDate));
        dayMenu.setLunchSide(menuService.findSide(dayMenu.getLunch(), "lunch",menuDate));
    }

    public Schedule MenuToSchedule(DayMenu dayMenu){
        Schedule schedule = new Schedule();

        schedule.setDate(dayMenu.getMenuDate());
        schedule.setBreakfastId(dayMenu.getBreakFast().getDishId());
        schedule.setBreakfast(dayMenu.getBreakFast().getName());
        schedule.setBreakfastSideId(dayMenu.getBreakFastSide().getSideId());
        schedule.setBreakfastSide(dayMenu.getBreakFastSide().getName());
        schedule.setLunchId(dayMenu.getLunch().getDishId());
        schedule.setLunch(dayMenu.getLunch().getName());
        schedule.setLunchSideId(dayMenu.getLunchSide().getSideId());
        schedule.setLunchSide(dayMenu.getLunchSide().getName());

        return schedule;
    }

    public List<Schedule> getScheduleForWeek(LocalDate date){
        DayOfWeek weekStart = DayOfWeek.SUNDAY;
        date = date.with(TemporalAdjusters.previousOrSame(weekStart));

        List<Schedule> weekMenu = new ArrayList<>();

        for(int i = 0; i<=6; i++){
            LocalDate menuDate = date.plusDays(i);
            weekMenu.add(scheduleRepo.findByDate(menuDate));
        }
        return weekMenu;
    }

}
