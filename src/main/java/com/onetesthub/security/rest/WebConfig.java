package com.onetesthub.security.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
/**
 * Web Configuration expose the all services
 * 
 * @author malalanayake
 * 
 */
@Configuration
@ComponentScan("com.onetesthub.controller")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
 
    public WebConfig() {
        super();
    }
 
}