package com.cbchak.springboot.MenuDharma.controller;

import com.cbchak.springboot.MenuDharma.domain.Schedule;
import com.cbchak.springboot.MenuDharma.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@Controller
public class AppController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/")
    public String Welcome(){
        return "welcome";
    }

    @RequestMapping(value = "get-menu", method = RequestMethod.GET)
    public String getCurentMenu(Model model){
        List<Schedule> weekMenu = scheduleService.getScheduleForWeek(LocalDate.now());
        model.addAttribute("weekMenu", weekMenu);
        return "menuPage";
    }
}
