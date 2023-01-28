package com.example.multipleDataSource.author;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = {"com.example.multipleDataSource.author"},
		entityManagerFactoryRef = "authorEntityManager",
		transactionManagerRef = "authorTxnManager")
public class AuthorDbConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.authords")
	public DataSource authorDatasource() {
		return DataSourceBuilder.create().build();
				
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean authorEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(authorDatasource());
		em.setPackagesToScan("com.example.multipleDataSource.author");
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("authords.hibernate.ddl-auto"));
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
		em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	@Bean
	public PlatformTransactionManager authorTxnManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(authorEntityManager().getObject());
		
		return jpaTransactionManager;
	}

}

