package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.PromotionDaoSql.SELECT_ALL_PROMOTION_IMAGE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.PromotionDto;

@Repository
public class PromotionDao {
	private final JdbcTemplate jdbcTemplate;
	
	public PromotionDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<PromotionDto> getPromotionImages() {
		return this.jdbcTemplate.query(SELECT_ALL_PROMOTION_IMAGE, new PromotionRowMapper());
	}	  
	
	private class PromotionRowMapper implements RowMapper<PromotionDto> {
		@Override
		public PromotionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new PromotionDto(
					rs.getInt("id"),
					rs.getInt("product_id"),
					rs.getString("product_image_url"),
					rs.getString("title"),
					rs.getString("place_name"),
					rs.getString("description")
			);
		}
	}
}
