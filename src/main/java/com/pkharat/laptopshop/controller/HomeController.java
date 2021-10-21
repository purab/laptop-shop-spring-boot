package com.pkharat.laptopshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class HomeController {
    public String viewHome() {
        return "home";
    }
}
