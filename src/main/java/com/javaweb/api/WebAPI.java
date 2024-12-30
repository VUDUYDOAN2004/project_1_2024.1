package com.javaweb.api;

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
import com.javaweb.service.ProductService;

@RestController
public class WebAPI {
	@Autowired
	private ProductService productService;
			
	
	
	@GetMapping(value = "/api/products/")
	public List<ProductDTO> getProducts(){
		List<ProductDTO> result = productService.findAll();
		return result;
	}
	
	
	
	
	@DeleteMapping(value = "api/testAPI/{id}/{name}/")
	public void deleteAPI(@PathVariable Integer id,
			@PathVariable String name,
			@RequestParam String address) {
		System.out.println("Xoa thanh cong " + id +  " " + name + " " + address);
	}
}
