package com.cbchak.springboot.MenuDharma;

import com.cbchak.springboot.MenuDharma.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class CLItest implements CommandLineRunner {

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public void run(String... args) throws Exception {
        //scheduleService.setScheduleForWeek(LocalDate.now().plusDays(8));

    }

}