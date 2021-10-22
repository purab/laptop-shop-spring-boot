package com.pkharat.laptopshop.service;

import com.pkharat.laptopshop.model.Role;
import com.pkharat.laptopshop.model.User;
import com.pkharat.laptopshop.repository.RoleRepository;
import com.pkharat.laptopshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        user.setEnabled(true);
        
        Role role = new Role("ADMIN");
		Role role1 = new Role("USER");		
		
		user.getRoles().add(role);
		user.getRoles().add(role1);        
        
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
