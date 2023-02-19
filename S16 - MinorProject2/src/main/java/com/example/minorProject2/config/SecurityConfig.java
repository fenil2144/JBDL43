package com.example.minorProject2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.minorProject2.enums.Authorities;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
					http
					.csrf().disable()
					.authorizeHttpRequests()
					.antMatchers("/saveStudent/**").permitAll()
					.antMatchers("/student/**").hasAuthority(Authorities.std.toString())
					.antMatchers("/admin/**").hasAuthority(Authorities.Adm.toString())
					.antMatchers("/saveBook/**").hasAuthority(Authorities.Adm.toString())
					.antMatchers("/book/search/**").hasAnyAuthority(Authorities.std.toString(),Authorities.Adm.toString())
					.antMatchers("/home").permitAll()
					.and().formLogin();
				}
	
}
