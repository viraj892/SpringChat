package com.viraj.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.viraj.dao.User;
import com.viraj.dao.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService service;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		List<User> allUsers = service.getAllUsers();
//		auth.inMemoryAuthentication().getUserDetailsService().createUser(service.getUserDetails());
		for (User user : allUsers) {
			auth.inMemoryAuthentication().withUser((String) user.getUsername()).password((String) user.getPassword())
					.roles("USER", "ADMIN");
		}
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/", "/*chat*/**", "/*welcome*/**")
				.access("hasRole('USER')").and().formLogin();
	}

}