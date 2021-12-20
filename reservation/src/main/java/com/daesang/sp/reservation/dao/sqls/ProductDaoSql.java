package com.daesang.sp.reservation.dao.sqls;

public class ProductDaoSql {
	private static final String SELECT_PRODUCTS = "SELECT "
			+ "product.id AS product_id, display_info.id AS display_info_id, product.description AS product_description, display_info.place_name AS place_name, product.content AS product_content, file_info.save_file_name AS product_image_url "
			+ "FROM product "
			+ "INNER JOIN display_info "
			+ "ON display_info.product_id = product.id "
			+ "INNER JOIN product_image "
			+ "ON product.id = product_image.product_id "
			+ "INNER JOIN file_info "
			+ "ON product_image.file_id = file_info.id "
			+ "WHERE product_image.type = 'th' ";
	
	private static final String SLICE_LIST = "LIMIT 4 OFFSET :start;";
	 
	private static final String SELECT_PRODUCT_COUNT = "SELECT "
			+ "COUNT(*) AS total_count "
			+ "FROM product "
			+ "INNER JOIN display_info "
			+ "ON display_info.product_id = product.id "
			+ "INNER JOIN category "
			+ "ON category.id = product.category_id";
	
	public static final String SELECT_ALL_PRODUCTS = SELECT_PRODUCTS + SLICE_LIST;
	
	public static final String SELECT_PRODUCTS_BY_CATEGORY_ID = SELECT_PRODUCTS
			+ "AND category_id = :categoryId " 
			+ SLICE_LIST;
			
	public static final String SELECT_ALL_PRODUCT_COUNT = SELECT_PRODUCT_COUNT + ";";
	
	public static final String SELECT_PRODUCT_COUNT_BY_CATEGORY_ID = SELECT_PRODUCT_COUNT 
			+ " WHERE category.id = :categoryId;";
}
