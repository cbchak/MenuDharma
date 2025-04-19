package com.cbchak.springboot.MenuDharma.repository;

import com.cbchak.springboot.MenuDharma.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepo extends JpaRepository<Dish, Integer> {

}
