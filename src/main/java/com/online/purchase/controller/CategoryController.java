package com.online.purchase.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @RequestMapping("/category/list")
    public String getCategoryList(){
        return "category-list";
    }

}
