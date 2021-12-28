package com.daesang.sp.reservation.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import com.daesang.sp.reservation.dto.ReservationPriceDto;

public class ReservationRequestDto {
	private int displayInfoId;
	private List<ReservationPriceDto> prices;
	private int productId;
	private String reservationEmail;
	private String reservationName;
	private String reservationTelephone;
	private LocalDateTime reservationYearMonthDay;
	
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
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

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
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

	public LocalDateTime getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}

	public void setReservationYearMonthDay(LocalDateTime reservationYearMonthDay) {
		this.reservationYearMonthDay = reservationYearMonthDay;
	}
}
