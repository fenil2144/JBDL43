package com.example.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic()
		.and().csrf().disable()
		.authorizeHttpRequests()
		.antMatchers(HttpMethod.POST,"/user/**").permitAll()
		.antMatchers("/user/**").hasAuthority(UserConstants.USER_AUTHORITY)
		.antMatchers("/admin/**").hasAnyAuthority(UserConstants.ADMIN_AUTHORITY,UserConstants.SERVICE_AUTHORITY)
		.and().formLogin();
	}

}
