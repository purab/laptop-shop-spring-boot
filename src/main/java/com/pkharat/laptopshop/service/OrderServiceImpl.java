package com.pkharat.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pkharat.laptopshop.model.Order;
import com.pkharat.laptopshop.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getAllOders() {		
		return orderRepository.findAll();
	}

	@Override
	public void saveOrder(Order order) {
		this.orderRepository.save(order);		
	}

	
	@Override
	public Order findByOrderId(long id) {
		Optional<Order> optional = orderRepository.findById(id);
		Order order = null;
		if(optional.isPresent()) {
			order = optional.get();
		} else {
			throw new RuntimeException(" Order not found for id :: " + id);
		}
		return order;
	}

	@Override
	public void deleteOrderById(long id) {
		this.orderRepository.deleteById(id);		
		
	}

	@Override
	public Page<Order> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.orderRepository.findAll(pageable);
	}

}
