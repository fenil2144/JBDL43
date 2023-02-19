package com.example.SecurityDemo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	//3 ways exist to give authorities
//	Role Based: Antmatchers will have multiple roles for a set of apis and 
//				user in db  will have single value.
//	Access Based:
//	Both: 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
					http.authorizeHttpRequests()
					.antMatchers("/developercode/**").hasAuthority("dev")
					.antMatchers("/testcode").hasAuthority("qa")
					.antMatchers("/generalcode").hasAnyAuthority("dev","qa")
					.antMatchers("/home").permitAll()
					.and().formLogin();
				}
	
	@Bean
	PasswordEncoder getPE() {
		return new BCryptPasswordEncoder();
	}

}
