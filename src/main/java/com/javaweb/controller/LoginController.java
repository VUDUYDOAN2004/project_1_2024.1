package com.javaweb.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.model.ProductDTO;
import com.javaweb.model.UserDTO;
import com.javaweb.service.impl.LoginService;
import com.javaweb.service.impl.ProductService;

@Controller
public class LoginController {
	@Autowired
    private LoginService loginService;
	
	@GetMapping(value = "/index")
    public ModelAndView productPage(@RequestParam(required = true) String email,
			@RequestParam(required = false) String password) {
//        UserDTO user = loginService.login(email, password);
        ModelAndView index = new ModelAndView("index");
        ModelAndView product = new ModelAndView("product");
        ModelAndView cart = new ModelAndView("cart");
        
        
//        index.addObject("user", user);
//        product.addObject("user", user);
//        cart.addObject("user", user);
//       
        
        return index;
    }
}
