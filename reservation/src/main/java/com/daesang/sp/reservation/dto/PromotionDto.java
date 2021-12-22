package com.daesang.sp.reservation.dto;

public class PromotionDto {
	private int id;
	private int productId;
	private String productImageUrl;
	private String title;
	private String placeName;
	private String description;
	
	public PromotionDto() {}
	
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

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
