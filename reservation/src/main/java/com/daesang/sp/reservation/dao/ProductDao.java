package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_ALL_PRODUCTS;
import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_ALL_PRODUCT_COUNT;
import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_PRODUCTS_BY_CATEGORY_ID;
import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_PRODUCT_COUNT_BY_CATEGORY_ID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.ProductDto;

@Repository
public class ProductDao {
	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final RowMapper<ProductDto> productRowMapper;
	
	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.productRowMapper = BeanPropertyRowMapper.newInstance(ProductDto.class);
	}
	
	public List<ProductDto> getProducts(int categoryId, int start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		
		return this.namedParameterJdbcTemplate.query(SELECT_PRODUCTS_BY_CATEGORY_ID, params, productRowMapper); 
	}
	
	public List<ProductDto> getProducts(int start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		
		return this.namedParameterJdbcTemplate
				.query(SELECT_ALL_PRODUCTS, params, productRowMapper);
	}
	
	public int getProductCount(int categoryId) {
		Map<String, Integer> params = Collections.singletonMap("categoryId", categoryId);
		return this.namedParameterJdbcTemplate
				.queryForObject(SELECT_PRODUCT_COUNT_BY_CATEGORY_ID, params, Integer.class);
	}
	
	public int getProductCount() {
		return this.jdbcTemplate.queryForObject(SELECT_ALL_PRODUCT_COUNT, Integer.class);
	}
}
