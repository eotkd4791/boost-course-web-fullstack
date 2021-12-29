package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.ReservationDaoSql.SELECT_DISPLAY_INFO_BY_EMAIL;
import static com.daesang.sp.reservation.dao.sqls.ReservationDaoSql.SELECT_PRODUCT_PRICES_BY_RESERVATION_ID;
import static com.daesang.sp.reservation.dao.sqls.ReservationDaoSql.SELECT_RESERVATIONS_BY_EMAIL;
import static com.daesang.sp.reservation.dao.sqls.ReservationDaoSql.SELECT_RESERVATION_BY_RESERVATION_INFO_ID;
import static com.daesang.sp.reservation.dao.sqls.ReservationDaoSql.SELECT_TOTAL_PRICE_BY_EMAIL;
import static com.daesang.sp.reservation.dao.sqls.ReservationDaoSql.UPDATE_RESERVATION_STATUS_BY_RESERVATION_INFO_ID;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.DisplayInfoDto;
import com.daesang.sp.reservation.dto.ReservationDto;
import com.daesang.sp.reservation.dto.ReservationPriceDto;
import com.daesang.sp.reservation.dto.response.ReservationResponseDto;

@Repository
public class ReservationDao {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final RowMapper<ReservationDto> reservationRowMapper;
	private final RowMapper<DisplayInfoDto> displayInfoRowMapper;
	private final RowMapper<ReservationPriceDto> priceRowMapper;
	
	public ReservationDao(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		this.reservationRowMapper = BeanPropertyRowMapper.newInstance(ReservationDto.class);
		this.displayInfoRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDto.class);
		this.priceRowMapper = BeanPropertyRowMapper.newInstance(ReservationPriceDto.class);
	}
	
	public List<ReservationDto> getReservations(String reservationEmail) {
		Map<String, String> params = Collections.singletonMap("reservationEmail", reservationEmail);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_RESERVATIONS_BY_EMAIL, 
				params, 
				this.reservationRowMapper
		);
	}

	public DisplayInfoDto getDisplayInfo(String reservationEmail) {
		Map<String, String> params = Collections.singletonMap("reservationEmail", reservationEmail);
		
		return this.namedParameterJdbcTemplate.queryForObject(
				SELECT_DISPLAY_INFO_BY_EMAIL, 
				params, 
				this.displayInfoRowMapper
		);
	}

	public int getTotalPrice(String reservationEmail) {
		Map<String, String> params = Collections.singletonMap("reservationEmail", reservationEmail);
		
		return this.namedParameterJdbcTemplate.queryForObject(
				SELECT_TOTAL_PRICE_BY_EMAIL, 
				params,
				Integer.class
		);
	}
	
	public int updateReservationStatus(int reservationInfoId) {
		Map<String, Integer> params = Collections.singletonMap("reservationInfoId", reservationInfoId);	
		
		return this.namedParameterJdbcTemplate.update(
				UPDATE_RESERVATION_STATUS_BY_RESERVATION_INFO_ID, 
				params
		);
	}
	
	public ReservationResponseDto getReservation(int reservationInfoId) {
		Map<String, Integer> params = Collections.singletonMap("reservationInfoId", reservationInfoId);
		
		return this.namedParameterJdbcTemplate.queryForObject(
				SELECT_RESERVATION_BY_RESERVATION_INFO_ID,
				params,
				ReservationResponseDto.class
		);
	}
	
	public List<ReservationPriceDto> getProductPrices(int reservationInfoId) {
		Map<String, Integer> params = Collections.singletonMap("reservationInfoId", reservationInfoId);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_PRODUCT_PRICES_BY_RESERVATION_ID, 
				params, 
				this.priceRowMapper
		);
	}
}
