package com.pkharat.laptopshop.repository;

import com.pkharat.laptopshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
