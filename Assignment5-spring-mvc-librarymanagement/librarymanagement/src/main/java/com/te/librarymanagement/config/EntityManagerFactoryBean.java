package com.te.librarymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryBean {
	@Bean
	public LocalEntityManagerFactoryBean bean() {
		LocalEntityManagerFactoryBean bean=new  LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("library");
		return bean;
	}

}
