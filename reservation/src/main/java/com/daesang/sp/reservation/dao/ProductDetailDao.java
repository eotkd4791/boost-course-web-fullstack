package com.daesang.sp.reservation.dao;

import static com.daesang.sp.reservation.dao.sqls.ProductDetailDaoSql.SELECT_AVERAGE_BY_DISPLAY_INFO_ID;
import static com.daesang.sp.reservation.dao.sqls.ProductDetailDaoSql.SELECT_ALL_COMMENTS_BY_DISPLAY_INFO_ID;
import static com.daesang.sp.reservation.dao.sqls.ProductDetailDaoSql.SELECT_SOME_COMMENT_IMAGES_BY_DISPLAY_INFO_ID;
import static com.daesang.sp.reservation.dao.sqls.ProductDetailDaoSql.SELECT_ONE_DISPLAY_INFO;
import static com.daesang.sp.reservation.dao.sqls.ProductDetailDaoSql.SELECT_ONE_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID;
import static com.daesang.sp.reservation.dao.sqls.ProductDetailDaoSql.SELECT_SOME_PRODUCT_IMAGES_BY_DISPLAY_INFO_ID;
import static com.daesang.sp.reservation.dao.sqls.ProductDetailDaoSql.SELECT_SOME_PRODUCT_PRICES_BY_DISPLAY_INFO_ID;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daesang.sp.reservation.dto.CommentDto;
import com.daesang.sp.reservation.dto.CommentImageDto;
import com.daesang.sp.reservation.dto.DisplayInfoDto;
import com.daesang.sp.reservation.dto.DisplayInfoImageDto;
import com.daesang.sp.reservation.dto.ProductImageDto;
import com.daesang.sp.reservation.dto.ProductPriceDto;

@Repository
public class ProductDetailDao {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final RowMapper<DisplayInfoDto> displayInfoDtoRowMapper;
	private final RowMapper<CommentDto> commentRowMapper;
	private final RowMapper<CommentImageDto> commentImageRowMapper;
	private final RowMapper<ProductImageDto> productImageRowMapper;
	private final RowMapper<ProductPriceDto> productPriceRowMapper;
	
	public ProductDetailDao(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		this.displayInfoDtoRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDto.class);
		this.commentRowMapper = BeanPropertyRowMapper.newInstance(CommentDto.class);
		this.commentImageRowMapper = BeanPropertyRowMapper.newInstance(CommentImageDto.class);
		this.productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImageDto.class);
		this.productPriceRowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDto.class);
	}

	public int getAverageScore(int displayInfoId) {
		Map<String, Integer> param = Collections.singletonMap("displayInfoId", displayInfoId);
		
		return this.namedParameterJdbcTemplate.queryForObject(
				SELECT_AVERAGE_BY_DISPLAY_INFO_ID, 
				param,
				Integer.class
		);
	}
	
	public DisplayInfoDto getDisplayInfo(int displayInfoId) {
		Map<String, Integer> param = Collections.singletonMap("displayInfoId", displayInfoId);
		
		return this.namedParameterJdbcTemplate.queryForObject(
				SELECT_ONE_DISPLAY_INFO, 
				param,
				displayInfoDtoRowMapper
		);
	}
	
	public DisplayInfoImageDto getDisplayInfoImage(int displayInfoId) {
		Map<String, Integer> param = Collections.singletonMap("displayInfoId", displayInfoId);
		
		return this.namedParameterJdbcTemplate.queryForObject(
				SELECT_ONE_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID, 
				param,
				DisplayInfoImageDto.class
		);
	}
	
	public List<CommentDto> getAllComments(int displayInfoId) {
		Map<String, Integer> param = Collections.singletonMap("displayInfoId", displayInfoId);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_ALL_COMMENTS_BY_DISPLAY_INFO_ID, 
				param, 
				commentRowMapper
		);
	}
	
	public List<CommentImageDto> getCommentImages(int displayInfoId) {
		Map<String, Integer> param = Collections.singletonMap("displayInfoId", displayInfoId);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_SOME_COMMENT_IMAGES_BY_DISPLAY_INFO_ID, 
				param, 
				commentImageRowMapper
		);
	}
	
	public List<ProductImageDto> getProductImages(int displayInfoId) {
		Map<String, Integer> param = Collections.singletonMap("displayInfoId", displayInfoId);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_SOME_PRODUCT_IMAGES_BY_DISPLAY_INFO_ID, 
				param,
				productImageRowMapper
		);
	}
	
	public List<ProductPriceDto> getAllProductPrices(int displayInfoId) {
		Map<String, Integer> param = Collections.singletonMap("displayInfoId", displayInfoId);
		
		return this.namedParameterJdbcTemplate.query(
				SELECT_SOME_PRODUCT_PRICES_BY_DISPLAY_INFO_ID, 
				param,
				productPriceRowMapper
		);
	}	
}
