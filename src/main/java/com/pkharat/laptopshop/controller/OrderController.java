package com.pkharat.laptopshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pkharat.laptopshop.model.Order;
import com.pkharat.laptopshop.repository.OrderRepository;
import com.pkharat.laptopshop.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderService orderService;
	

	@GetMapping("/orders")
	public String listOrders(Model model) {
		return findPaginated(1, "status", "asc", model);	
	}
	
	@GetMapping("/order/showNewOrderForm")
	public String showNewOrderForm(Model model) {
		// create model attribute to bind form data
		Order order = new Order();
		model.addAttribute("order", order);
		return "new_order";
	}
	
	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") Order order) {
		// save order to database
		orderService.saveOrder(order);
		return "redirect:/orders";
	}
	
	@PostMapping("/orderLaptop/{laptopId}")
	public String orderLaptop(@PathVariable (value = "laptopId") long laptopId, @RequestBody String request) {
		// save order to database
		//orderService.saveOrder(order);
		System.out.println(request);
		System.out.println(laptopId);
		
		return "redirect:/orders";
	}
	
	@GetMapping("/order/deleteOrder/{id}")
	public String deleteOrder(@PathVariable (value = "id") long id) {		
		// call delete order method 
		this.orderService.deleteOrderById(id);
		
		return "redirect:/orders";
	}
	
	@GetMapping("/order/showOrderFormForUpdate/{id}")
	public String showOrderFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get order from the service		
		Order order =orderService.findByOrderId(id);
		
		System.out.println(order);
		
		// set order as a model attribute to pre-populate the form
		model.addAttribute("order", order);
		return "update_order";
	}
	
	
	@GetMapping("/orderpage/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Order> page = orderService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Order> listOrders = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listOrders", listOrders);
		return "orders";
	}

}
