package com.daesang.sp.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daesang.sp.reservation.dao.CategoryDao;
import com.daesang.sp.reservation.dto.CategoryDto;
import com.daesang.sp.reservation.dto.response.CategoryResponseDto;
import com.daesang.sp.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public CategoryResponseDto getAllCategories() {
		List<CategoryDto> categories = categoryDao.getCategories();
		return new CategoryResponseDto(categories);
	}
}
