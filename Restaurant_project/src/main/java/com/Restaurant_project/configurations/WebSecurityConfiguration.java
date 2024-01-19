package com.Restaurant_project.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {
@Bean

public SecurityFilterChain securityFilterChain (HttpSecurity http)throws Exception{
	http.csrf(AbstractHttpConfigurer::disable)	
	.authorizeHttpRequests(request -> request.requestMatchers("/api/auth/**")
	.permitAll()
	.anyRequest().authenticated())
	.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	return http.build();
}


public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
	
	
}
