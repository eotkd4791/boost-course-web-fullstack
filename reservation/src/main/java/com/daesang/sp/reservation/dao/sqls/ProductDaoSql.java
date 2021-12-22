package com.daesang.sp.reservation.dao.sqls;

public class ProductDaoSql {
	public static final String SELECT_ALL_PRODUCTS = "SELECT"
			+ " p.id AS product_id"
			+ " ,di.id AS display_info_id"
			+ " ,p.description AS product_description"
			+ " ,di.place_name"
			+ " ,p.content AS product_content"
			+ " ,fi.save_file_name AS product_image_url"
			+ " FROM product p"
			+ " INNER JOIN display_info di"
			+ " ON di.product_id = p.id"
			+ " INNER JOIN product_image pi"
			+ " ON p.id = pi.product_id "
			+ " INNER JOIN file_info fi"
			+ " ON pi.file_id = fi.id "
			+ " WHERE pi.type = 'th'"
			+ " LIMIT 4 OFFSET :start;";
	
	public static final String SELECT_PRODUCTS_BY_CATEGORY_ID = "SELECT"
			+ " p.id AS product_id"
			+ " ,di.id AS display_info_id"
			+ " ,p.description AS product_description"
			+ " ,di.place_name AS place_name"
			+ " ,p.content AS product_content"
			+ " ,fi.save_file_name AS product_image_url"
			+ " FROM product p"
			+ " INNER JOIN display_info di"
			+ " ON di.product_id = p.id"
			+ " INNER JOIN product_image pi"
			+ " ON p.id = pi.product_id"
			+ " INNER JOIN file_info fi"
			+ " ON pi.file_id = fi.id"
			+ " WHERE pi.type = 'th'"
			+ " AND p.category_id = :categoryId"
			+ " LIMIT 4 OFFSET :start;";
			
	public static final String SELECT_ALL_PRODUCT_COUNT = "SELECT"
			+ " COUNT(*) AS total_count"
			+ " FROM product p"
			+ " INNER JOIN display_info di"
			+ " ON di.product_id = p.id "
			+ " INNER JOIN category c"
			+ " ON c.id = p.category_id;";
	
	public static final String SELECT_PRODUCT_COUNT_BY_CATEGORY_ID = "SELECT"
			+ " COUNT(*) AS total_count"
			+ " FROM product p"
			+ " INNER JOIN display_info di"
			+ " ON di.product_id = p.id"
			+ " INNER JOIN category c"
			+ " ON c.id = p.category_id" 
			+ " WHERE c.id = :categoryId;";	
}
