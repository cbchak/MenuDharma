package com.cbchak.springboot.MenuDharma.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class dishes {
    @Id
    private Integer dishId;
    @Column
    private String name;
    @Column
    private String mealTime;
    @Column
    private boolean containsRice;
    @Column
    private boolean needSide;
}
