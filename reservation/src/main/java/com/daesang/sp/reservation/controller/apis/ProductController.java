package com.daesang.sp.reservation.controller.apis;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.reservation.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public Map<String, Object> getProducts(
			@RequestParam(
					name = "categoryId", required = false, defaultValue="0"		
			) 
			int categoryId,
			@RequestParam(
					name = "start", required = false, defaultValue = "0"
			) 
			int start
	) {		
		System.out.println(categoryId + " " + start);
		return this.productService.getProducts(categoryId, start);
	}
}