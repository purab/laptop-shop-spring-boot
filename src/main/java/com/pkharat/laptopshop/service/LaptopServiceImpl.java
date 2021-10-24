package com.pkharat.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pkharat.laptopshop.model.Laptop;
import com.pkharat.laptopshop.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService{
	
	@Autowired
	private LaptopRepository laptopRepository;
	

	@Override
	public List<Laptop> getAllLaptops() {
		return laptopRepository.findAll();
	}

	@Override
	public void saveLaptop(Laptop laptop) {
		this.laptopRepository.save(laptop);		
	}

	@Override
	public Laptop getLaptopById(long id) {
		Optional<Laptop> optional = laptopRepository.findById(id);
		Laptop laptop = null;
		if (optional.isPresent()) {
			laptop = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return laptop;
	}
	
	@Override
	public Laptop findByLaptopId(long id) {
		Optional<Laptop> optional = laptopRepository.findByLaptopId(id);
		Laptop laptop = null;
		if (optional.isPresent()) {
			laptop = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return laptop;
	}

	@Override
	public void deleteLaptopById(long id) {
		this.laptopRepository.deleteById(id);		
	}

	@Override
	public Page<Laptop> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.laptopRepository.findAll(pageable);
	}

}
