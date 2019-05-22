package com.online.purchase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController  {


    @RequestMapping("/")
    public String getHomePage(){
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}
