package com.turkcell.rentACar1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACar1Application {

	public static void main(String[] args) {

			SpringApplication.run(RentACar1Application.class, args);
		}
		@Bean
		public ModelMapper getModelMapper(){
			return new ModelMapper();
		}
}
