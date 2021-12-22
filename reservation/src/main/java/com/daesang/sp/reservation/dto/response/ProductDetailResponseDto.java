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
	
	public ProductDetailResponseDto(
			int averageScore, 
			List<CommentDto> comments, 
			DisplayInfoDto displayInfo,
			DisplayInfoImageDto displayInfoImage, 
			List<ProductImageDto> productImages,
			List<ProductPriceDto> productPrices
	) {
		this.averageScore = averageScore;
		this.comments = comments;
		this.displayInfo = displayInfo;
		this.displayInfoImage = displayInfoImage;
		this.productImages = productImages;
		this.productPrices = productPrices;
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
