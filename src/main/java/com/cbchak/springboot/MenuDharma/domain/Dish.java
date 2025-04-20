package com.cbchak.springboot.MenuDharma.domain;

import com.cbchak.springboot.MenuDharma.enums.DishTypes;
import com.cbchak.springboot.MenuDharma.enums.MealTimes;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "dishMaster")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dish {
    @Id
    @NonNull
    private Integer dishId;
    @Column
    @NonNull
    private String name;
    @Column
    private String mealTimes;
    @Column
    private String dishType;
}
