package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.PromotionDaoSql.SELECT_ALL_PROMOTION_IMAGES;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.PromotionDto;

@Repository
public class PromotionDao {
	private final JdbcTemplate jdbcTemplate;
	private final RowMapper<PromotionDto> promotionImageRowMapper;
	
	public PromotionDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.promotionImageRowMapper = BeanPropertyRowMapper.newInstance(PromotionDto.class);
	}
	
	public List<PromotionDto> getPromotionImages() {
		return this.jdbcTemplate
				.query(SELECT_ALL_PROMOTION_IMAGES, this.promotionImageRowMapper);
	}	  
}
