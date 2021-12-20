package com.daesang.sp.reservation.service;

import java.util.Map;

public interface ProductService {
	Map<String, Object> getProducts(int categoryId, int start);
	Map<String, Object> getProducts(int start);
}
