package com.daesang.sp.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daesang.sp.reservation.dao.ProductDao;
import com.daesang.sp.reservation.dto.ProductDto;
import com.daesang.sp.reservation.dto.response.ProductResponseDto;
import com.daesang.sp.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductDao productDao;
	private final int ALL_CATEGORY;
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
		this.ALL_CATEGORY = 0;
	}
	
	@Override
	public ProductResponseDto getProducts(int categoryId, int start) {
		if(categoryId == ALL_CATEGORY) {
			return this.getProducts(start); 
		}
		return new ProductResponseDto(
				this.getProductCountByCategoryId(categoryId),
				this.getProductListByCategoryId(categoryId, start)
		); 
	}
	
	@Override
	public ProductResponseDto getProducts(int start) {
		return new ProductResponseDto(
				this.getAllCategoriesTotalCount(),
				this.getProductListByAllCategories(start)
		);
	}
	
	private int getAllCategoriesTotalCount() {
		return productDao.getProductCount();
	}
	
	private int getProductCountByCategoryId(int categoryId) {
		return productDao.getProductCount(categoryId);	
	}
	
	private List<ProductDto> getProductListByAllCategories(int start) {
		return productDao.getProducts(start);
	}
	
	private List<ProductDto> getProductListByCategoryId(int categoryId, int start) {
		return productDao.getProducts(categoryId, start);
	}
}