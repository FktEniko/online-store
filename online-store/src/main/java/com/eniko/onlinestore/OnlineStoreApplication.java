package com.eniko.onlinestore;

import com.eniko.onlinestore.dto.CategoryDTO;
import com.eniko.onlinestore.serivce.CategoryService;
import com.eniko.onlinestore.serivce.impl.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OnlineStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	CategoryService categoryService = new CategoryServiceImpl();


}
