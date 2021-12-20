package com.daesang.sp.reservation.controller.apis;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.reservation.dto.PromotionDto;
import com.daesang.sp.reservation.service.PromotionService;

@RestController
public class PromotionController {
	private final PromotionService promotionService;
	
	public PromotionController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}
	
	@GetMapping("/api/promotions")
	public Map<String, List<PromotionDto>> getPromotionImages() {
		return promotionService.getPromotionImages();
	}
}