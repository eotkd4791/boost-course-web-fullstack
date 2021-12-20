package com.daesang.sp.reservation.controller.apis;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.reservation.dto.CategoryDto;
import com.daesang.sp.reservation.service.CategoryService;

@RestController
public class CategoryController {
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/api/categories")
	public Map<String, List<CategoryDto>> getCategories() {
		return categoryService.getCategories();
	}
}
