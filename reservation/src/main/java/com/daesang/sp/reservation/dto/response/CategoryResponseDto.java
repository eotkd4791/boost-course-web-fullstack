package com.daesang.sp.reservation.dto.response;

import java.util.List;

import com.daesang.sp.reservation.dto.CategoryDto;

public class CategoryResponseDto {
	private final List<CategoryDto> categories;
	
	public CategoryResponseDto(List<CategoryDto> categories) {
		this.categories = categories;
	}
	
	public List<CategoryDto> getCategories() {
		return this.categories;
	}
}