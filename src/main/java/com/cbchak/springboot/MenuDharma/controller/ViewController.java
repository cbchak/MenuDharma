package com.cbchak.springboot.MenuDharma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String Welcome(){
        return "welcome";
    }

}
