package com.cbchak.springboot.MenuDharma.repository;

import com.cbchak.springboot.MenuDharma.domain.dishes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface dishInterface extends CrudRepository<dishes, Integer> {
    dishes findBydishId(Integer Id);

    List<dishes> findByMealTime(String mealTime);

}
