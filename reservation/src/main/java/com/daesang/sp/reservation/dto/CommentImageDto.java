package com.daesang.sp.reservation.dto;

import java.time.LocalDateTime;

public class CommentImageDto {
	private int reservationUserCommentId;
	private int imageId;
	private int fileId;
	private int reservationInfoId;
	private String contentType;
	private String saveFileName;
	private boolean deleteFlag;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	
	public CommentImageDto() {}
	public CommentImageDto(
			int reservationUserCommentId, 
			int imageId, 
			int fileId, 
			int reservationInfoId,
			String contentType, 
			String saveFileName, 
			boolean deleteFlag, 
			LocalDateTime createDate,
			LocalDateTime modifyDate
	) {
		this.reservationUserCommentId = reservationUserCommentId;
		this.imageId = imageId;
		this.fileId = fileId;
		this.reservationInfoId = reservationInfoId;
		this.contentType = contentType;
		this.saveFileName = saveFileName;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}
	
	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}
	
	public int getImageId() {
		return imageId;
	}
	
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
	public int getFileId() {
		return fileId;
	}
	
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getSaveFileName() {
		return saveFileName;
	}
	
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
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
