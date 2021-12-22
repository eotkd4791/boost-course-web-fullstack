package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.CategoryDaoSql.SELECT_ALL_CATEGORY;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.CategoryDto;

@Repository
public class CategoryDao {
	private final JdbcTemplate jdbcTemplate;
	
	public CategoryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<CategoryDto> getCategories() {
		return this.jdbcTemplate.query(SELECT_ALL_CATEGORY, new CategoryRowMapper());
	}	  
	
	private class CategoryRowMapper implements RowMapper<CategoryDto> {
		@Override
		public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new CategoryDto(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("count")
			);
		}	
	}	
}
