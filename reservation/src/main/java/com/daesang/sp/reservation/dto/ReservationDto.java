package com.daesang.sp.reservation.dto;

import java.time.LocalDateTime;

public class ReservationDto {
	private int reservationInfoId;
	private boolean cancelYn;
	private LocalDateTime createDate;
	private DisplayInfoDto displayInfo;
	private int displayInfoId;
	private LocalDateTime modifyDate;
	private int productId;
	private LocalDateTime reservationDate;
	private String reservationEmail;
	private String reservationTelephone;
	private int totalPrice;
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public DisplayInfoDto getDisplayInfo() {
		return displayInfo;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public int getProductId() {
		return productId;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public String getReservationTelephone() {
		return reservationTelephone;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public boolean isCancelYn() {
		return cancelYn;
	}

	public void setCancelYn(boolean cancelYn) {
		this.cancelYn = cancelYn;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public void setDisplayInfo(DisplayInfoDto displayInfo) {
		this.displayInfo = displayInfo;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public void setReservationTelephone(String reservationTelephone) {
		this.reservationTelephone = reservationTelephone;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
