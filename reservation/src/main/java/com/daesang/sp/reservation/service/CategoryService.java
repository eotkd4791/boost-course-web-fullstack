package com.daesang.sp.reservation.service;

import java.util.List;
import java.util.Map;

import com.daesang.sp.reservation.dto.CategoryDto;

public interface CategoryService {
	Map<String, List<CategoryDto>> getCategories(); 
}
