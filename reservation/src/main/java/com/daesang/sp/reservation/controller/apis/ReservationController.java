package com.daesang.sp.reservation.controller.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.daesang.sp.reservation.dto.request.CommentRequestDto;
import com.daesang.sp.reservation.dto.request.ReservationRequestDto;
import com.daesang.sp.reservation.dto.response.ReservationResponseDto;
import com.daesang.sp.reservation.dto.response.CommentResponseDto;
import com.daesang.sp.reservation.dto.response.MyReservationsResponseDto;
import com.daesang.sp.reservation.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public MyReservationsResponseDto myreservation(
		@SessionAttribute("reservationEmail") String reservationEmail
	) {
		return this.reservationService.getReservations(reservationEmail);
	}
	
	@PostMapping
	public ReservationResponseDto insertReservation(@ModelAttribute ReservationRequestDto reservation) {
		return this.reservationService.createNewReservation(reservation);
	}
	
	@PutMapping("/{reservationInfoId}")
	public ReservationResponseDto cancelReservation(@RequestParam int reservationInfoId) {
		return this.reservationService.updateReservationStatus(reservationInfoId);
	}

	@PostMapping("/{reservationInfoId}/comments")
	public CommentResponseDto addComment(@ModelAttribute CommentRequestDto commentRequest) {
		return this.reservationService.addComment(commentRequest);
	}
}
