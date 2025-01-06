package com.javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.model.ProductDTO;
import com.javaweb.service.impl.ProductService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@Autowired
    private ProductService productService;
	
	
//    HttpServletRequest request
    @GetMapping(value="/")
    public ModelAndView home(){
       ModelAndView mav = new ModelAndView("index");
       List<ProductDTO> products = productService.findAll();
       mav.addObject("products", products);
        return mav;
    	
    }

    @GetMapping(value="/products")
    public String productPage() {
    	return "product";
    }
    @GetMapping(value="/cart")
    public String cartPage() {
    	return "cart";
    }
    @GetMapping(value="/login")
    public String loginPage() {
    	return "login";
    }
    
    @GetMapping(value = "/products/category")
    public ModelAndView productPage(@RequestParam("category") String category) {
        List<ProductDTO> products = productService.findByCategory(category);
        ModelAndView mav = new ModelAndView("index"); 
        
        mav.addObject("category", category);
        mav.addObject("products", products);
        
        return mav;
    }
    
    



}
