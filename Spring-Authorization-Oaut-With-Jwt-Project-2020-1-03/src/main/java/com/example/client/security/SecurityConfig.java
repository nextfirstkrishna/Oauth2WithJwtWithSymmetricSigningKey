package com.example.client.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserDetailsService crmService;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	 @Autowired
	    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .userDetailsService(crmService)
	            .passwordEncoder(passwordEncoder);    
	    }
	    
	    @Bean
		public PasswordEncoder passwordEncoder() {
		    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		}
}
