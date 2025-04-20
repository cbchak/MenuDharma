package com.cbchak.springboot.MenuDharma.service;

import com.cbchak.springboot.MenuDharma.domain.Dish;
import com.cbchak.springboot.MenuDharma.repository.DishRepoH2;
import com.cbchak.springboot.MenuDharma.repository.DishRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceH2 implements DishRepoInterface {

    @Autowired
    private DishRepoH2 dishRepo;

    public List<Dish> getAllDishes() {
        return dishRepo.findAll();
    }

    public Optional<Dish> getDishById(Integer id) {
        return dishRepo.findById(id);
    }

    public Dish addDish(Dish dish) {
        Dish savedDish = dishRepo.save(dish);
        return savedDish;
    }

    public Dish updateDish(Integer id, Dish dish){
        Dish targetDish = dishRepo.findById(id).orElseThrow();
        targetDish.setName(dish.getName());
        targetDish.setMealTimes(dish.getMealTimes());
        dishRepo.save(targetDish);
        return targetDish;
    }

    public void deleteById(Integer id) {
        dishRepo.deleteById(id);
    }


}
