package com.daesang.sp.reservation.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.daesang.sp.reservation.dao.ProductDao;
import com.daesang.sp.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Map<String, Object> getProducts(int categoryId, int start) {
		if(categoryId == 0) {
			return this.productDao.getProductListWithTotalCount(start); 
		}
		return this.productDao.getProductListWithTotalCount(categoryId, start);
	}
	
	@Override
	public Map<String, Object> getProducts(int start) {
		return this.productDao.getProductListWithTotalCount(start);
	}
}