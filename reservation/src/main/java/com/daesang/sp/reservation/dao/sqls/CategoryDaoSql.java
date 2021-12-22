package com.daesang.sp.reservation.dao.sqls;

public class CategoryDaoSql {
	public static final String SELECT_ALL_CATEGORIES = "SELECT"
			+ " c.id"
			+ " ,c.name"
			+ " ,COUNT(*) AS count"
			+ " FROM category c"
			+ " INNER JOIN product p"
			+ " ON c.id = p.category_id"
			+ " INNER JOIN display_info di"
			+ " ON p.id = di.product_id"
			+ " GROUP BY c.id;";
}
