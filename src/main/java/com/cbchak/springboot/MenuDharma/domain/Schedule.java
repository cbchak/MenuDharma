package com.cbchak.springboot.MenuDharma.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @Column
    private Integer breakfastId;
    @Column
    private String breakfast;
    @Column
    private Integer breakfastSideId;
    @Column
    private String breakfastSide;
    @Column
    private Integer LunchId;
    @Column
    private String lunch;
    @Column
    private Integer LunchSideId;
    @Column
    private String lunchSide;
}
