package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests( authorize -> authorize	
			.anyRequest().authenticated()
		)
		.formLogin( formlogin -> formlogin
			.loginPage("/login")
			.defaultSuccessUrl("/booklist", true)
			.permitAll()
		)
		.logout( logout -> logout
				.permitAll()
		);
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		List<UserDetails> users =  new ArrayList<UserDetails>();
		UserDetails user = User.withDefaultPasswordEncoder()
			.username("user")
			.password("password")
			.roles("USER")
			.build();
		users.add(user);
		
		user = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("password")
				.roles("ADMIN")
				.build();
		users.add(user);
		
		return new InMemoryUserDetailsManager(users);
	}

}
