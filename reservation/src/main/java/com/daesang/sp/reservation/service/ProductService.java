package com.daesang.sp.reservation.service;

import com.daesang.sp.reservation.dto.response.ProductResponseDto;

public interface ProductService {
	ProductResponseDto getProducts(int categoryId, int start);
	ProductResponseDto getProducts(int start);
}
