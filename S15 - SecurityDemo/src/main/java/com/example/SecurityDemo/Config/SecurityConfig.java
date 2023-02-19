package com.example.SecurityDemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("karan").password("karan123")
			.authorities("dev")
			.and()
			.withUser("arsalan").password("arsalan123").authorities("qa");
	}
	
	//3 ways exist to give authorities
//	Role Based: Antmatchers will have multiple roles for a set of apis and 
//				user in db  will have single value.
//	Action based: Ant Matcher will have single role for a set of apis
//				user in db will have multiple actions in authority column.
//	Both: Using Role and Access based both
	
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
		return NoOpPasswordEncoder.getInstance();
	}

}
