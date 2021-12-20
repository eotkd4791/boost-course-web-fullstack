package com.daesang.sp.reservation.dto;

public class PromotionDto {
	private final int id;
	private final int productId;
	private final String productImageUrl;
	private final String title;
	private final String placeName;
	private final String description;
	
	public PromotionDto(int id, int productId, String productImageUrl, String title, String placeName, String description) {
		this.id = id;
		this.productId = productId;
		this.productImageUrl = productImageUrl;
		this.title = title;
		this.placeName = placeName;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public String getProductImageUrl() {
		return productImageUrl;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getPlaceName() {
		return placeName;
	}
	
	public String getDescription() {
		return description;
	}
}
