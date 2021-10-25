package com.pkharat.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pkharat.laptopshop.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
