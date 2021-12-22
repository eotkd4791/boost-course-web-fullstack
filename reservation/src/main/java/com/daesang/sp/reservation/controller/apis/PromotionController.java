package com.daesang.sp.reservation.controller.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daesang.sp.reservation.dto.response.PromotionResponseDto;
import com.daesang.sp.reservation.service.PromotionService;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
	private final PromotionService promotionService;
	
	public PromotionController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}
	
	@GetMapping
	public PromotionResponseDto getPromotionImages() {
		return promotionService.getPromotionImages();
	}
}