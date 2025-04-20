package com.cbchak.springboot.MenuDharma.controller;

import com.cbchak.springboot.MenuDharma.domain.Dish;
import com.cbchak.springboot.MenuDharma.repository.DishRepoInterface;
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
    private DishRepoInterface dishService;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping("/{id}")
    public Optional<Dish> getDishById(@PathVariable Integer id) {
        return dishService.getDishById(id);
    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        Dish savedDish = dishService.addDish(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDish);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Integer id, @RequestBody Dish dish){
        Dish updatedDish = dishService.updateDish(id, dish);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDish);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        dishService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
