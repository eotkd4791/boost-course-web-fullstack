package com.daesang.sp.reservation.dto.response;

import java.util.List;

import com.daesang.sp.reservation.dto.PromotionDto;

public class PromotionResponseDto {
	private final List<PromotionDto> promotions;
	
	public PromotionResponseDto(List<PromotionDto> promotions) {
		this.promotions = promotions;
	}
	
	public List<PromotionDto> getPromotions() {
		return this.promotions;
	}
}
