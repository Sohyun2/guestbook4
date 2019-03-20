package com.douzone.guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.douzone.guestbook.controller")
/*
 * @Configuration..
 * spring-servlet.xml과 역할이 같음

 * @EnalbeWebMvc..
 * <mvc:annotaion-driven /> 같음
 * default Servlet handler를 쓰려면 반드시 있어야함
 
 * @ComponentScan..
	<context:annotation-config />
	<context:component-scan base-package="com.douzone.hellospring.controller" />
 */
public class WebConfig {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		
		return resolver;
	}
}
