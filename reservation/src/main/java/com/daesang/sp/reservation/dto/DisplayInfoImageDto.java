package com.daesang.sp.reservation.dto;

import java.time.LocalDateTime;

public class DisplayInfoImageDto {
	private int displayInfoImageId;
	private int displayInfoId;
	private int fileId;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private boolean deleteFlag;
	private LocalDateTime modifyDate;
	private LocalDateTime createDate;
	
	public int getDisplayInfoImageId() {
		return displayInfoImageId;
	}
	
	public void setDisplayInfoImageId(int displayInfoImageId) {
		this.displayInfoImageId = displayInfoImageId;
	}
	
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	
	public int getFileId() {
		return fileId;
	}
	
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getSaveFileName() {
		return saveFileName;
	}
	
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
}
