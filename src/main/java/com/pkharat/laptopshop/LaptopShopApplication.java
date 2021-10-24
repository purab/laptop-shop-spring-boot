package com.pkharat.laptopshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.pkharat.laptopshop.repository.LaptopRepository;


@SpringBootApplication
public class LaptopShopApplication extends SpringBootServletInitializer {
	
	
	
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(LaptopShopApplication.class);
	  }

	public static void main(String[] args) {
		SpringApplication.run(LaptopShopApplication.class, args);
		
	}

}
