package com.cbchak.springboot.MenuDharma.repository;

import com.cbchak.springboot.MenuDharma.domain.dishes;
import com.cbchak.springboot.MenuDharma.domain.sideDishes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface sideDishesInterface extends CrudRepository<sideDishes, Integer> {
    List<sideDishes> findByGoesWith(Integer goesWith);
}
