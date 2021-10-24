package com.pkharat.laptopshop.repository;

import com.pkharat.laptopshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("Select u from User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
}
