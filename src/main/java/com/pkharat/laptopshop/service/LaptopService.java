package com.pkharat.laptopshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.pkharat.laptopshop.model.Laptop;


public interface LaptopService {
	
	List<Laptop> getAllLaptops();
	void saveLaptop(Laptop laptop);
	Laptop getLaptopById(long id);
	Laptop findByLaptopId(long id);
	void deleteLaptopById(long id);
	Page<Laptop> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
