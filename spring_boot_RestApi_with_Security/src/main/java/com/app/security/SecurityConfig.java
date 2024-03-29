package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	
    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtFilter filter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
 
    	
    	http
    	.csrf()
    	.disable()
    	.authorizeHttpRequests()
//    	.requestMatchers("/auth/login").permitAll()
    	.anyRequest()
    	.authenticated()
    	.and()
    	.exceptionHandling().authenticationEntryPoint(this.point)
    	.and()
    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	
    	http.addFilterBefore(this.filter, UsernamePasswordAuthenticationFilter.class);	
    	
    }
    
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}