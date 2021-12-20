package com.daesang.sp.reservation.dto;

public class ProductDto {
	private final int displayInfoId;
	private final int productId;
	private final String productDescription;
	private final String placeName;
	private final String productContent;
	private final String productImageUrl;
	
	public ProductDto(
			int displayInfoId, 
			int productId, 
			String productDescription, 
			String placeName, 
			String productContent, 
			String productImageUrl
	) {
		this.displayInfoId = displayInfoId;
		this.productId = productId;
		this.productDescription = productDescription;
		this.placeName = placeName;
		this.productContent = productContent;
		this.productImageUrl = productImageUrl;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public String getPlaceName() {
		return placeName;
	}

	public String getProductContent() {
		return productContent;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}
	
	
}
