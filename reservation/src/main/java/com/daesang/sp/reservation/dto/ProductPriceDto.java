package com.daesang.sp.reservation.dto;
import java.time.LocalDateTime;

public class ProductPriceDto {
	private int productPriceId;
	private int productId;
	private int price;
	private int discountRate;
	private String priceTypeName;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	
	public ProductPriceDto() {}
	
	public ProductPriceDto(
			int productPriceId, 
			int productId, 
			int price, 
			int discountRate, 
			String priceTypeName,
			LocalDateTime createDate, 
			LocalDateTime modifyDate
	) {
		this.productPriceId = productPriceId;
		this.productId = productId;
		this.price = price;
		this.discountRate = discountRate;
		this.priceTypeName = priceTypeName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}
}
