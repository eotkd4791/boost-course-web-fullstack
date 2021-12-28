package com.daesang.sp.reservation.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.daesang.sp.reservation.dto.ReservationPriceDto;

public class ReservationResponseDto {
	private boolean cancelYn;
	private LocalDateTime createDate;
	private int displayInfoId;
	private LocalDateTime modifyDate;
	private List<ReservationPriceDto> prices;
	private int productId;
	private LocalDateTime reservationDate;
	private String reservationEmail;
	private int reservationInfoId;
	private String reservationName;
	private String reservationTelephone;
	
	public boolean isCancelYn() {
		return cancelYn;
	}
	
	public void setCancelYn(boolean cancelYn) {
		this.cancelYn = cancelYn;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public List<ReservationPriceDto> getPrices() {
		return prices;
	}
	
	public void setPrices(List<ReservationPriceDto> prices) {
		this.prices = prices;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public LocalDateTime getReservationDate() {
		return reservationDate;
	}
	
	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	public String getReservationEmail() {
		return reservationEmail;
	}
	
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	
	public String getReservationName() {
		return reservationName;
	}
	
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	
	public String getReservationTelephone() {
		return reservationTelephone;
	}
	
	public void setReservationTelephone(String reservationTelephone) {
		this.reservationTelephone = reservationTelephone;
	}
}
