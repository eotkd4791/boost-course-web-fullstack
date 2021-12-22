package com.daesang.sp.reservation.service;

import java.util.List;
import java.util.Map;

import com.daesang.sp.reservation.dto.PromotionDto;

public interface PromotionService {
	Map<String, List<PromotionDto>> getPromotionImages();
}
