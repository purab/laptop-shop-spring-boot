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
import org.springframework.web.bind.annotation.RequestParam;

import com.pkharat.laptopshop.model.Laptop;
import com.pkharat.laptopshop.repository.LaptopRepository;
import com.pkharat.laptopshop.service.LaptopService;

@Controller
public class LaptopController {
	
	@Autowired
	public LaptopService laptopService;
	
	@Autowired
	public LaptopRepository laptopRepository;
	
	@GetMapping("/laptops")
	public String listLaptops(Model model) {
		return findPaginated(1, "type", "asc", model);	
	}
	
	@GetMapping("/showNewLaptopForm")
	public String showNewLaptopForm(Model model) {
		// create model attribute to bind form data
		Laptop laptop = new Laptop();
		model.addAttribute("laptop", laptop);
		return "new_laptop";
	}
	
	@PostMapping("/saveLaptop")
	public String saveLaptop(@ModelAttribute("laptop") Laptop laptop) {
		// save laptop to database
		laptopService.saveLaptop(laptop);
		return "redirect:/laptops";
	}
	
	@GetMapping("/deleteLaptop/{id}")
	public String deleteLaptop(@PathVariable (value = "id") long id) {
		
		// call delete laptop method 
		this.laptopService.deleteLaptopById(id);
		return "redirect:/laptops";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get laptop from the service
		//Laptop laptop = laptopService.getLaptopById(id);
		Laptop laptop =laptopService.findByLaptopId(id);
		
		System.out.println(laptop);
		
		// set laptop as a model attribute to pre-populate the form
		model.addAttribute("laptop", laptop);
		return "update_laptop";
	}

	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Laptop> page = laptopService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Laptop> listLaptops = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listLaptops", listLaptops);
		return "laptops";
	}
}
