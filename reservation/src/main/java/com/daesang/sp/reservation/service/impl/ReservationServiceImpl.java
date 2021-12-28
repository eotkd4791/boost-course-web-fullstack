package com.daesang.sp.reservation.service.impl;

import static com.daesang.sp.reservation.utils.Constants.END_OF_BUFFER;
import static com.daesang.sp.reservation.utils.Constants.FILE_UPLOAD_ERROR_MESSAGE;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.daesang.sp.reservation.dao.ReservationDao;
import com.daesang.sp.reservation.dto.DisplayInfoDto;
import com.daesang.sp.reservation.dto.ReservationDto;
import com.daesang.sp.reservation.dto.ReservationPriceDto;
import com.daesang.sp.reservation.dto.request.CommentRequestDto;
import com.daesang.sp.reservation.dto.request.ReservationRequestDto;
import com.daesang.sp.reservation.dto.response.CommentResponseDto;
import com.daesang.sp.reservation.dto.response.MyReservationsResponseDto;
import com.daesang.sp.reservation.dto.response.ReservationResponseDto;
import com.daesang.sp.reservation.service.ReservationService;

@Service
@PropertySource("classpath:/application.properties")
public class ReservationServiceImpl implements ReservationService {
	private final ReservationDao reservationDao;
	
	@Value("${file.path}")
	private String filePath;
	
	public ReservationServiceImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Override
	@Transactional
	public MyReservationsResponseDto getReservations(String reservationEmail) {
		List<ReservationDto> reservations = this.reservationDao.getReservations(reservationEmail);
		DisplayInfoDto displayInfo = this.reservationDao.getDisplayInfo(reservationEmail);
		int totalPrice = this.reservationDao.getTotalPrice(reservationEmail);
		
		for(ReservationDto reservation : reservations) {
			int reservationDisplayInfoId = reservation.getDisplayInfoId();
			int displayInfoId = displayInfo.getDisplayInfoId(); 
			
			if(reservationDisplayInfoId == displayInfoId) {
				reservation.setDisplayInfo(displayInfo);
			}
			reservation.setTotalPrice(totalPrice);
		}
		return new MyReservationsResponseDto(reservations.size(), reservations);
	}
	
	@Override
	public ReservationResponseDto createNewReservation(ReservationRequestDto reservationRequest) {
		ReservationResponseDto reservationResponse = new ReservationResponseDto();
		reservationResponse.setCancelYn(false);
		reservationResponse.setCreateDate(LocalDateTime.now());
		reservationResponse.setDisplayInfoId((int) Math.random() * 20);
		reservationResponse.setModifyDate(LocalDateTime.now());
		reservationResponse.setProductId((int) Math.random() * 20);
		reservationResponse.setReservationDate(LocalDateTime.now());
		reservationResponse.setReservationEmail("eotkd4791@lycos.com");
		reservationResponse.setReservationInfoId((int) Math.random() * 20);
		reservationResponse.setReservationName("스티븐");
		reservationResponse.setReservationTelephone("010-1234-5678");
		return reservationResponse;
	}

	@Override
	@Transactional
	public ReservationResponseDto updateReservationStatus(int reservationInfoId) {
		this.reservationDao.updateReservationStatus(reservationInfoId);
		
		ReservationResponseDto reservationResponse = this.reservationDao.getReservation(reservationInfoId);
		
		List<ReservationPriceDto> prices = this.reservationDao.getProductPrices(reservationInfoId);
		reservationResponse.setPrices(prices);
		
		return reservationResponse;
	}
	
	@Override
	public CommentResponseDto addComment(CommentRequestDto commentRequest) {
		readCommentImage(commentRequest);
		return createCommentResponse(commentRequest);
	}
	
	public void readCommentImage(CommentRequestDto commentRequest) {
		MultipartFile imageFile = commentRequest.getAttachedImage();
		String imageFileName = imageFile.getOriginalFilename();
		
		try {			
			FileOutputStream fileOutputStream = new FileOutputStream(this.filePath + imageFileName);
			InputStream inputStream = imageFile.getInputStream();
			
			int fileReadCount = 0;
			byte[] imageFileBuffer = new byte[1024];
			
			while((fileReadCount = inputStream.read(imageFileBuffer)) != END_OF_BUFFER) {
				fileOutputStream.write(imageFileBuffer, 0, fileReadCount);
			}
			
			fileOutputStream.close();
			inputStream.close();
		} catch(Exception e) {
			throw new RuntimeException(FILE_UPLOAD_ERROR_MESSAGE);
		}
	}
	
	public CommentResponseDto createCommentResponse(CommentRequestDto commentRequest) {
		String comment = commentRequest.getComment();
		// CommentImageDto commentImage
		int productId = commentRequest.getProductId();
		int reservationInfoId = commentRequest.getReservationInfoId();
		int score = commentRequest.getScore();
		
		return new CommentResponseDto(
				comment, 
				null, 
				0, 
				productId, 
				reservationInfoId, 
				score
		);
	}
}
