package com.javaweb.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.model.ProductDTO;
import com.javaweb.service.impl.ProductService;

@Controller
public class ProductController {
	@Autowired
    private ProductService productService;
	
	@GetMapping(value = "/products/filter")
    public ModelAndView productPage(@RequestParam(required = false) BigDecimal minprice,
			@RequestParam(required = false) BigDecimal maxprice,
	        @RequestParam(required = false) String size) {
        List<ProductDTO> products = productService.findByFilter(minprice, maxprice, size);
        ModelAndView mav = new ModelAndView("product"); 

        mav.addObject("products", products);
        
        return mav;
    }
	@GetMapping(value = "/products/name")
    public ModelAndView productPage(@RequestParam(required = false) String name) {
        List<ProductDTO> products = productService.findByName(name);
        ModelAndView mav = new ModelAndView("product"); 

        mav.addObject("products", products);
        
        return mav;
    }

	
}
