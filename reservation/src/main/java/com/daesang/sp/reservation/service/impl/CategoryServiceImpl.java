package com.daesang.sp.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.daesang.sp.reservation.dao.CategoryDao;
import com.daesang.sp.reservation.dto.CategoryDto;
import com.daesang.sp.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Map<String, List<CategoryDto>> getCategories() {
		List<CategoryDto> categories = categoryDao.getCategories();
		
		Map<String, List<CategoryDto>> response = new HashMap<>();
		response.put("items", categories);
		return response;
	}
}
