package com.cbchak.springboot.MenuDharma.repository;

import com.cbchak.springboot.MenuDharma.domain.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepoInterface {
    public List<Dish> getAllDishes();

    public Optional<Dish> getDishById(Integer id);

    public Dish addDish(Dish dish);

    public Dish updateDish(Integer id, Dish dish);

    public void deleteById(Integer id);
}
