package com.daesang.sp.reservation.dto.request;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

public class CommentRequestDto {
	private String comment;
	private MultipartFile attachedImage;
	private int productId;
	private int reservationInfoId;
	private int score;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	
	public CommentRequestDto() {
		this.createDate = LocalDateTime.now();
		this.modifyDate = LocalDateTime.now();
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public MultipartFile getAttachedImage() {
		return attachedImage;
	}
	
	public void setAttachedImage(MultipartFile attachedImage) {
		this.attachedImage = attachedImage;
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
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}	
}
