package com.daesang.sp.reservation.dao.sqls;

public class CategoryDaoSql {
	public static final String SELECT_ALL_CATEGORY = "SELECT "
			+ "category.id, category.name, COUNT(*) AS count "
			+ "FROM category "
			+ "INNER JOIN product "
			+ "ON category.id = product.category_id "
			+ "INNER JOIN display_info "
			+ "ON product.id = display_info.product_id "
			+ "GROUP BY category.id;";
}
