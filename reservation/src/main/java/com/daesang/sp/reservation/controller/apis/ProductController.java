package com.daesang.sp.reservation.controller.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.reservation.dto.response.ProductDetailResponseDto;
import com.daesang.sp.reservation.dto.response.ProductResponseDto;
import com.daesang.sp.reservation.service.ProductDetailService;
import com.daesang.sp.reservation.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;
	private final ProductDetailService productDetailService;
	
	public ProductController(ProductService productService, ProductDetailService productDetailService) {
		this.productService = productService;
		this.productDetailService = productDetailService;
	}
	
	@GetMapping
	public ProductResponseDto getProducts(
			@RequestParam(required = false, defaultValue = "0") int categoryId,
			@RequestParam(defaultValue = "0") int start
	) {
		return this.productService.getProducts(categoryId, start);
	}
	
	@GetMapping("/{displayInfoId}")
	public ProductDetailResponseDto getProductDetail(@PathVariable int displayInfoId) {
		return this.productDetailService.getProductDetail(displayInfoId);
	}
}