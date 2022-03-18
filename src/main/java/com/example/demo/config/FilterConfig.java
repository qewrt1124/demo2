package com.example.demo.config;

import com.example.demo.filter.IPCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Filter> getFilterRegistrationBean() {
        FilterRegistrationBean<Filter> bean =
                new FilterRegistrationBean<>(new IPCheckFilter());
        bean.addUrlPatterns("/visitor");
        return bean;
    }
}
