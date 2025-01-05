package com.javaweb.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.ProductDTO;

import com.javaweb.service.impl.ProductService;


@RestController
public class ProductAPI {
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping(value = "/api/products")
	public List<ProductDTO> getProducts(){
		List<ProductDTO> result = productService.findAll();
		return result;
	}
	
	@GetMapping(value = "/products/price")
	public List<ProductDTO> price(@RequestParam BigDecimal minprice, 
			@RequestParam BigDecimal maxprice){
		List<ProductDTO> result = productService.findByPrice(minprice, maxprice);
		return result;
	}
//	@GetMapping(value = "/products/name")
//	public List<ProductDTO> name(@RequestParam String name){
//		List<ProductDTO> result = productService.findByName(name);
//		return result;
//	}
//	@GetMapping(value = "/products/category")
//	public List<ProductDTO> category(@RequestParam String category){
//		List<ProductDTO> result = productService.findByCategory(category);
//		return result;
//	}
	@GetMapping(value = "/products/size/{size}")
	public List<ProductDTO> size(@PathVariable String size){
		List<ProductDTO> result = productService.findBySize(size);
		return result;
	}
//	@GetMapping(value = "/products/filter")
//	public List<ProductDTO> filter(@RequestParam(required = false) BigDecimal minprice,
//			@RequestParam(required = false) BigDecimal maxprice,
//	        @RequestParam(required = false) String size){
//		List<ProductDTO> result = productService.findByFilter(minprice, maxprice, size);
//		return result;
//	}
	
	
	
	
}
