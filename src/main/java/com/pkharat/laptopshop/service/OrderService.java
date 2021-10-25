package com.pkharat.laptopshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pkharat.laptopshop.model.Order;

public interface OrderService {
	
	List<Order> getAllOders();
	void saveOrder(Order order);	
	Order findByOrderId(long id);
	void deleteOrderById(long id);
	Page<Order> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
