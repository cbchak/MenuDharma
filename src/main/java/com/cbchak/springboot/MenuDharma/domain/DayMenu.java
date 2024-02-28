package com.cbchak.springboot.MenuDharma.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DayMenu {

    private LocalDate menuDate;
    private dishes breakFast;
    private sideDishes breakFastSide;
    private dishes lunch;
    private sideDishes lunchSide;

}
