package com.daesang.sp.reservation.service.impl;

import static com.daesang.sp.reservation.utils.Constants.CATEGORY_ALL;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daesang.sp.reservation.dao.ProductDao;
import com.daesang.sp.reservation.dto.ProductDto;
import com.daesang.sp.reservation.dto.response.ProductResponseDto;
import com.daesang.sp.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	@Transactional
	public ProductResponseDto getProducts(int categoryId, int start) {
		if(categoryId == CATEGORY_ALL) {
			return this.getProducts(start); 
		}
		return new ProductResponseDto(
				this.getProductCount(categoryId),
				this.getProductByCategoryId(categoryId, start)
		); 
	}
	
	@Override
	@Transactional
	public ProductResponseDto getProducts(int start) {
		return new ProductResponseDto(
				this.getTotalCount(),
				this.getProductAll(start)
		);
	}

	private int getTotalCount() {
		return productDao.getProductCount();
	}
	
	private int getProductCount(int categoryId) {
		return productDao.getProductCount(categoryId);	
	}
	
	private List<ProductDto> getProductAll(int start) {
		return productDao.getProducts(start);
	}
	
	private List<ProductDto> getProductByCategoryId(int categoryId, int start) {
		return productDao.getProducts(categoryId, start);
	}
}