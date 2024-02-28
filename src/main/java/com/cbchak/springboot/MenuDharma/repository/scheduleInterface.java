package com.cbchak.springboot.MenuDharma.repository;

import com.cbchak.springboot.MenuDharma.domain.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface scheduleInterface extends CrudRepository<Schedule, Integer> {
    @Query("select max(a.date) from Schedule a where a.breakfastId = :id")
    LocalDate findLastMadeDateBreakfast (@Param("id") Integer id);

    @Query("select max(a.date) from Schedule a where a.breakfastSideId = :id")
    LocalDate findLastMadeDateBreakfastSide (@Param("id") Integer id);

    @Query("select max(a.date) from Schedule a where a.LunchId = :id")
    LocalDate findLastMadeDateLunch (@Param("id") Integer id);

    @Query("select max(a.date) from Schedule a where a.LunchSideId = :id")
    LocalDate findLastMadeDateLunchSide (@Param("id") Integer id);

    Schedule findByDate (LocalDate date);


}
