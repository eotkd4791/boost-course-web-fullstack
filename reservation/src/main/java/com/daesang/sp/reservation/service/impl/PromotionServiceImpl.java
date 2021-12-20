package com.daesang.sp.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.daesang.sp.reservation.dao.PromotionDao;
import com.daesang.sp.reservation.dto.PromotionDto;
import com.daesang.sp.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	private final PromotionDao promotionDao;
	
	public PromotionServiceImpl(PromotionDao promotionDao) {
		this.promotionDao = promotionDao;
	}
	
	@Override
	public Map<String, List<PromotionDto>> getPromotionImages() {
		List<PromotionDto> promotionImages = this.promotionDao.getPromotionImages();
		
		Map<String, List<PromotionDto>> response = new HashMap<>();
		response.put("items", promotionImages);
		return response;
	}
}
