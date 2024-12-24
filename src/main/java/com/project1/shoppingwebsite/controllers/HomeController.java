package com.project1.shoppingwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Trang chủ (index.html)
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart"; // Trang giỏ hàng (cart.html)
    }
}