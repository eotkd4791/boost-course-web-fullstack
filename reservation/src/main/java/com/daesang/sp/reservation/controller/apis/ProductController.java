package com.daesang.sp.reservation.controller.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.reservation.dto.response.ProductResponseDto;
import com.daesang.sp.reservation.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public ProductResponseDto getProducts(
			@RequestParam(required = false, defaultValue = "0") int categoryId,
			@RequestParam(defaultValue = "0") int start
	) {
		return this.productService.getProducts(categoryId, start);
	}	
}