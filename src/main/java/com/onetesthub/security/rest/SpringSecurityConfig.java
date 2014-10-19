package com.onetesthub.security.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
 
 
/**
 * Expose the Spring Security Configuration
 * 
 * 
 */
@Configuration
@ImportResource({ "classpath:spring-security.xml" })
@ComponentScan("com.onetesthub.security.rest")
public class SpringSecurityConfig {
 
    public SpringSecurityConfig() {
        super();
    }
 
}