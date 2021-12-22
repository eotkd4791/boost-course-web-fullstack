package com.daesang.sp.reservation.dto.response;

import java.util.List;

import com.daesang.sp.reservation.dto.ProductDto;

public class ProductResponseDto {
	private final int totalCount;
	private final List<ProductDto> products;
	
	public ProductResponseDto(int totalCount, List<ProductDto> products) {
		this.totalCount = totalCount;
		this.products = products;
	}
	
	public int getTotalCount() {
		return this.totalCount;
	}
	
	public List<ProductDto> getProducts() {
		return this.products;
	}
}
