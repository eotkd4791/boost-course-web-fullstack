package com.daesang.sp.reservation.service.impl;

import org.springframework.stereotype.Service;

import com.daesang.sp.reservation.dao.PromotionDao;
import com.daesang.sp.reservation.dto.response.PromotionResponseDto;
import com.daesang.sp.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	private final PromotionDao promotionDao;
	
	public PromotionServiceImpl(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}
	
	@Override
	public PromotionResponseDto getPromotionImages() {
		return new PromotionResponseDto(this.promotionDao.getPromotionImages());
	}
}
