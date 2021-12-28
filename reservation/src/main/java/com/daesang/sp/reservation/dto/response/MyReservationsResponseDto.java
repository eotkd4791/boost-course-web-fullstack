package com.daesang.sp.reservation.dto.response;

import java.util.List;

import com.daesang.sp.reservation.dto.ReservationDto;

public class MyReservationsResponseDto {
	private final int size;
	private final List<ReservationDto> reservations;
	
	public MyReservationsResponseDto(int size, List<ReservationDto> reservations) {
		this.size = size;
		this.reservations = reservations;
	}
	
	public int getSize() {
		return size;
	}
	
	public List<ReservationDto> getReservations() {
		return reservations;
	}
}
