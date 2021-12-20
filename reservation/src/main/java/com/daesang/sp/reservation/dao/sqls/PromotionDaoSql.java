package com.daesang.sp.reservation.dao.sqls;

public class PromotionDaoSql {
	public static final String SELECT_ALL_PROMOTION_IMAGE = "SELECT "
			+ "promotion.id, promotion.product_id, file_info.save_file_name AS product_image_url, product.description AS title, display_info.place_name AS place_name, product.content AS description "
			+ "FROM promotion "
			+ "INNER JOIN product "
			+ "ON promotion.product_id = product.id "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "INNER JOIN product_image "
			+ "ON promotion.product_id = product_image.product_id AND product_image.type = 'th' "
			+ "INNER JOIN file_info "
			+ "ON product_image.file_id = file_info.id;";
}
