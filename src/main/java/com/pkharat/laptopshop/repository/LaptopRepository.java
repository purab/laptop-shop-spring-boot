package com.pkharat.laptopshop.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pkharat.laptopshop.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{
	
	Optional<Laptop> findByLaptopId(Long id);	
	
}
