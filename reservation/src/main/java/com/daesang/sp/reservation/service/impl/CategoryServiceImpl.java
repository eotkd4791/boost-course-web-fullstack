package com.daesang.sp.reservation.service.impl;

import org.springframework.stereotype.Service;

import com.daesang.sp.reservation.dao.CategoryDao;
import com.daesang.sp.reservation.dto.response.CategoryResponseDto;
import com.daesang.sp.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public CategoryResponseDto getCategories() {
		return new CategoryResponseDto(categoryDao.getCategories());
	}
}
