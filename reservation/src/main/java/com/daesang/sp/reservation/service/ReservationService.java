package com.daesang.sp.reservation.service;

import com.daesang.sp.reservation.dto.request.CommentRequestDto;
import com.daesang.sp.reservation.dto.request.ReservationRequestDto;
import com.daesang.sp.reservation.dto.response.ReservationResponseDto;
import com.daesang.sp.reservation.dto.response.CommentResponseDto;
import com.daesang.sp.reservation.dto.response.MyReservationsResponseDto;

public interface ReservationService {
	MyReservationsResponseDto getReservations(String reservationEmail);
	ReservationResponseDto createNewReservation(ReservationRequestDto reservationRequest);
	ReservationResponseDto updateReservationStatus(int reservationInfoId);
	CommentResponseDto addComment(CommentRequestDto commentRequest);
}
