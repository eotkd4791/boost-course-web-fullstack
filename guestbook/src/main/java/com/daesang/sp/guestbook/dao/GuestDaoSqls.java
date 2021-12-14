package com.daesang.sp.guestbook.dao;

public class GuestDaoSqls {
	public static String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
	public static String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
	public static String SELECT_COUNT = "SELECT count(*) FROM guestbook";
}
