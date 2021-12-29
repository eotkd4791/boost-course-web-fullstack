package com.daesang.sp.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daesang.sp.reservation.dao.ProductDetailDao;
import com.daesang.sp.reservation.dto.CommentDto;
import com.daesang.sp.reservation.dto.CommentImageDto;
import com.daesang.sp.reservation.dto.DisplayInfoDto;
import com.daesang.sp.reservation.dto.DisplayInfoImageDto;
import com.daesang.sp.reservation.dto.ProductImageDto;
import com.daesang.sp.reservation.dto.ProductPriceDto;
import com.daesang.sp.reservation.dto.response.ProductDetailResponseDto;
import com.daesang.sp.reservation.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
	private final ProductDetailDao productDetailDao; 
	
	public ProductDetailServiceImpl(ProductDetailDao productDetailDao) {
		this.productDetailDao = productDetailDao;
	}

	@Override
	@Transactional
	public ProductDetailResponseDto getProductDetail(int displayInfoId) {
		int averageScore = this.productDetailDao
				.getAverageScore(displayInfoId);
		
		DisplayInfoDto displayInfo = this.productDetailDao
				.getDisplayInfo(displayInfoId);
		
		DisplayInfoImageDto displayInfoImage = this.productDetailDao
				.getDisplayInfoImage(displayInfoId);
		
		List<ProductImageDto> productImages = this.productDetailDao
				.getProductImages(displayInfoId);
		
		List<ProductPriceDto> productPrices = this.productDetailDao
				.getAllProductPrices(displayInfoId);
		
		List<CommentDto> comments = this.productDetailDao
				.getAllComments(displayInfoId);
		
		List<CommentImageDto> commentImages = this.productDetailDao
				.getCommentImages(displayInfoId);
		
		List<CommentDto> commentsMappedWithImages = this.mapCommentImageToComment(comments, commentImages);
		
		return new ProductDetailResponseDto.Builder()
				.averageScore(averageScore)
				.comments(commentsMappedWithImages)
				.displayInfo(displayInfo)
				.displayInfoImage(displayInfoImage)
				.productImages(productImages)
				.productPrices(productPrices)
				.builder();
	}
	
	private List<CommentDto> mapCommentImageToComment(List<CommentDto> comments, List<CommentImageDto> commentImages) {
		for(CommentDto comment : comments) {
			List<CommentImageDto> commentImagesWithMatchedCommentId = new ArrayList<>();
			int commentId = comment.getCommentId();
		
			for(CommentImageDto commentImage : commentImages) {
				int commentIdByCommentImage = commentImage.getReservationUserCommentId();
				
				if(commentId == commentIdByCommentImage) {
					commentImagesWithMatchedCommentId.add(commentImage);					
				}
			}
			comment.setCommentImages(commentImagesWithMatchedCommentId);
		}
		return comments;
	}
}
