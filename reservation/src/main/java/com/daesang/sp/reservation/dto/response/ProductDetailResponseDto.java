package com.daesang.sp.reservation.dto.response;

import java.util.List;

import com.daesang.sp.reservation.dto.CommentDto;
import com.daesang.sp.reservation.dto.DisplayInfoDto;
import com.daesang.sp.reservation.dto.DisplayInfoImageDto;
import com.daesang.sp.reservation.dto.ProductImageDto;
import com.daesang.sp.reservation.dto.ProductPriceDto;

public class ProductDetailResponseDto {
	private final int averageScore;
	private final List<CommentDto> comments;
	private final DisplayInfoDto displayInfo;
	private final DisplayInfoImageDto displayInfoImage;
	private final List<ProductImageDto> productImages;
	private final List<ProductPriceDto> productPrices;
	
	
	public static class Builder {
		private int averageScore;
		private List<CommentDto> comments;
		private DisplayInfoDto displayInfo;
		private DisplayInfoImageDto displayInfoImage;
		private List<ProductImageDto> productImages;
		private List<ProductPriceDto> productPrices;
		
		public Builder averageScore(int averageScore) {
			this.averageScore = averageScore;
			return this;
		}
		
		public Builder comments(List<CommentDto> comments) {
			this.comments = comments;
			return this;
		}
		
		public Builder displayInfo(DisplayInfoDto displayInfo) {
			this.displayInfo = displayInfo;
			return this;
		}
		
		public Builder displayInfoImage(DisplayInfoImageDto displayInfoImage) {
			this.displayInfoImage = displayInfoImage;
			return this;
		}
		
		public Builder productImages(List<ProductImageDto> productImages) {
			this.productImages = productImages;
			return this;
		}
		
		public Builder productPrices(List<ProductPriceDto> productPrices) {
			this.productPrices = productPrices;
			return this;
		}
		
		public ProductDetailResponseDto builder() {
			return new ProductDetailResponseDto(this);
		}
	}
	
	private ProductDetailResponseDto(Builder builder) {
		averageScore = builder.averageScore;
		comments = builder.comments;
		displayInfo = builder.displayInfo;
		displayInfoImage = builder.displayInfoImage;
		productImages = builder.productImages;
		productPrices = builder.productPrices;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public DisplayInfoDto getDisplayInfo() {
		return displayInfo;
	}

	public DisplayInfoImageDto getDisplayInfoImage() {
		return displayInfoImage;
	}

	public List<ProductImageDto> getProductImages() {
		return productImages;
	}

	public List<ProductPriceDto> getProductPrices() {
		return productPrices;
	}
}
