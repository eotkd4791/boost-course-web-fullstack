package com.daesang.sp.reservation.service;

import com.daesang.sp.reservation.dto.response.ProductDetailResponseDto;

public interface ProductDetailService {
	ProductDetailResponseDto getProductDetail(int displayInfoId);
}
