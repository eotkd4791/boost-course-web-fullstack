package com.daesang.sp.reservation.controller.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.reservation.dto.response.CategoryResponseDto;
import com.daesang.sp.reservation.service.CategoryService;

@RestController
public class CategoryController {
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/api/categories")
	public CategoryResponseDto getCategories() {
		return categoryService.getCategories();
	}
}
