package com.mrsisa.eclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EclinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(EclinicApplication.class, args);
	}
	
@Bean
WebMvcConfigurer conf() {

	return new WebMvcConfigurer() {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		}
	};
}
}
