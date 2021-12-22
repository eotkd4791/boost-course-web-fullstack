package com.daesang.sp.reservation.dao.sqls;

public class PromotionDaoSql {
	public static final String SELECT_ALL_PROMOTION_IMAGES = "SELECT"
			+ " p.id"
			+ " ,p.product_id"
			+ " ,fi.save_file_name AS product_image_url"
			+ " ,p2.description AS title"
			+ " ,di.place_name AS place_name"
			+ " ,p2.content AS description"
			+ " FROM promotion p"
			+ " INNER JOIN product p2"
			+ " ON p.product_id = p2.id"
			+ " INNER JOIN display_info di"
			+ " ON p2.id = di.product_id"
			+ " INNER JOIN product_image pi"
			+ " ON p.product_id = pi.product_id AND pi.type = 'th'"
			+ " INNER JOIN file_info fi"
			+ " ON pi.file_id = fi.id;";
}
