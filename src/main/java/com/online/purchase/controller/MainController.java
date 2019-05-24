package com.online.purchase.controller;

import com.online.purchase.model.Product;
import com.online.purchase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.modelmbean.ModelMBean;
import javax.validation.constraints.Max;
import java.util.List;

@Controller
public class MainController  {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String getHomePage(ModelMap model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}
