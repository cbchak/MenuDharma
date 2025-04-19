package com.cbchak.springboot.MenuDharma.controller;

import com.cbchak.springboot.MenuDharma.domain.Dish;
import com.cbchak.springboot.MenuDharma.repository.DishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dishes")
public class ApiController {

    @Autowired
    private DishRepo dishRepo;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepo.findAll();
    }

    @GetMapping("/{Id}")
    public Optional<Dish> getDishById(@PathVariable Integer Id) {
        return dishRepo.findById(Id);
    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        Dish savedDish = dishRepo.save(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDish);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Integer Id, @RequestBody Dish dish){
        Dish targetDish = dishRepo.findById(Id).orElseThrow();
        targetDish.setDishId(dish.getDishId());
        targetDish.setName(dish.getName());
        targetDish.setMealTime(dish.getMealTime());
        dishRepo.save(targetDish);
        return ResponseEntity.status(HttpStatus.OK).body(targetDish);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer Id) {
        dishRepo.deleteById(Id);
        return ResponseEntity.noContent().build();
    }

}
