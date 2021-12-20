package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_ALL_PRODUCTS;
import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_ALL_PRODUCT_COUNT;
import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_PRODUCTS_BY_CATEGORY_ID;
import static com.daesang.sp.reservation.dao.sqls.ProductDaoSql.SELECT_PRODUCT_COUNT_BY_CATEGORY_ID;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.ProductDto;

@Repository
public class ProductDao {
	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public ProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public class ProductRowMapper implements RowMapper<ProductDto> {
		@Override
		public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new ProductDto(
					rs.getInt("display_info_id"),
					rs.getInt("product_id"),
					rs.getString("product_description"),
					rs.getString("place_name"),
					rs.getString("product_content"),
					rs.getString("product_image_url")
			);
		}
	}
	
	private List<ProductDto> getProducts(int categoryId, int start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_PRODUCTS_BY_CATEGORY_ID, 
				params,
				new ProductRowMapper()
		); 
	}
	
	private List<ProductDto> getProducts(int start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_ALL_PRODUCTS, 
				params, 
				new ProductRowMapper()
		);
	}
	
	private int getProductCount(int categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		
		return this.namedParameterJdbcTemplate.queryForObject(
				SELECT_PRODUCT_COUNT_BY_CATEGORY_ID, 
				params, 
				Integer.class
		);
	}
	
	private int getProductCount() {
		return this.jdbcTemplate.queryForObject(
				SELECT_ALL_PRODUCT_COUNT, 
				Integer.class
		);
	}
	
	private Map<String, Object> getMappedProduct(int totalCount, List<ProductDto> products) {
		Map<String, Object> productListWithTotalCount = new HashMap<>();
		productListWithTotalCount.put("totalCount", totalCount);
		productListWithTotalCount.put("items", products);
		return productListWithTotalCount;
	}
	
	public Map<String, Object> getProductListWithTotalCount(int categoryId, int start) {
		int totalCount = getProductCount(categoryId);
		List<ProductDto> products = getProducts(categoryId, start);
		
		return getMappedProduct(totalCount, products);
	}
	
	public Map<String, Object> getProductListWithTotalCount(int start) {
		int totalCount = getProductCount();
		List<ProductDto> products = getProducts(start);
		
		return getMappedProduct(totalCount, products);
	}
}
