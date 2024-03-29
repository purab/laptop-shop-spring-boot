package com.pkharat.laptopshop.config;

import com.pkharat.laptopshop.interceptor.LoggerInterceptor;
import com.pkharat.laptopshop.interceptor.LoginInterceptors;
import com.pkharat.laptopshop.interceptor.SessionTimerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new LoginInterceptors());
       // registry.addInterceptor(new SessionTimerInterceptor());
    }

}
