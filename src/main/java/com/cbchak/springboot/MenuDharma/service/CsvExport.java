package com.cbchak.springboot.MenuDharma.service;

import com.cbchak.springboot.MenuDharma.domain.Schedule;
import com.cbchak.springboot.MenuDharma.repository.scheduleInterface;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

public class CsvExport {
    @Autowired
    private static scheduleInterface scheduleRepo;

    public static void writeToCsv() throws IOException {
        FileWriter writer = new FileWriter("/schedule.csv");

        Iterable<Schedule> schedules = scheduleRepo.findAll();

        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        csvPrinter.printRecord("id", "date", "breakfast","breakfastSide","lunch", "lunchSide");
        for (Schedule schedule : schedules) {
            csvPrinter.printRecord();
        }

    }

}
