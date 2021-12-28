package com.daesang.sp.reservation.dto.response;

import java.time.LocalDateTime;

import com.daesang.sp.reservation.dto.CommentImageDto;

public class CommentResponseDto {
	private final String comment;
	private final CommentImageDto commentImage;
	private final int commentId;
	private final int productId;
	private final int reservationInfoId;
	private final int score;
	private final LocalDateTime createDate;
	private final LocalDateTime modifyDate;
	
	public CommentResponseDto(
			String comment, 
			CommentImageDto commentImage, 
			int commentId, 
			int productId,
			int reservationInfoId, 
			int score
	) {
		this.comment = comment;
		this.commentId = commentId;
		this.commentImage = commentImage;
		this.productId = productId;
		this.reservationInfoId = reservationInfoId;
		this.score = score;
		this.createDate = LocalDateTime.now();
		this.modifyDate = LocalDateTime.now();
	}

	public String getComment() {
		return comment;
	}

	public CommentImageDto getCommentImage() {
		return commentImage;
	}

	public int getCommentId() {
		return commentId;
	}

	public int getProductId() {
		return productId;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public int getScore() {
		return score;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}
}
