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
	
	public static class Builder {
		private final int commentId;
		private final int productId;
		private final int reservationInfoId;
		private final CommentImageDto commentImage;
		private int score;
		private String comment;
		
		public Builder( 
			int commentId, 
			int productId,
			int reservationInfoId,
			CommentImageDto commentImage
		) {
			this.commentId = commentId;
			this.reservationInfoId = reservationInfoId;
			this.productId = productId;
			this.commentImage = commentImage;
		}
		
		public Builder comment(String comment) {
			this.comment = comment;
			return this;
		}
		
		public Builder score(int score) {
			this.score = score;
			return this;
		}
		
		public CommentResponseDto build() {
			return new CommentResponseDto(this);
		}
	}
	
	private CommentResponseDto(Builder builder) {
		comment = builder.comment;
		commentId = builder.commentId;
		commentImage = builder.commentImage;
		productId = builder.productId;
		reservationInfoId = builder.reservationInfoId;
		score = builder.score;
		createDate = LocalDateTime.now();
		modifyDate = LocalDateTime.now();
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
