package com.userservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.MediaType;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		/*
		 * RestTemplate restTemplate = new RestTemplate(); List<HttpMessageConverter<?>>
		 * messageConverters = new ArrayList<>(); MappingJackson2HttpMessageConverter
		 * converter = new MappingJackson2HttpMessageConverter();
		 * converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		 * messageConverters.add(converter);
		 * restTemplate.setMessageConverters(messageConverters); return restTemplate;
		 */
		return new RestTemplate();
	}

}
