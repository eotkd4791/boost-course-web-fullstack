package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.CategoryDaoSql.SELECT_ALL_CATEGORIES;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.CategoryDto;

@Repository
public class CategoryDao {
	private final JdbcTemplate jdbcTemplate;
	private final RowMapper<CategoryDto> categoryRowMapper;
	
	public CategoryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.categoryRowMapper = BeanPropertyRowMapper.newInstance(CategoryDto.class);
	}
	
	public List<CategoryDto> getCategories() {
		return this.jdbcTemplate.query(SELECT_ALL_CATEGORIES, categoryRowMapper);
	}	  	
}
