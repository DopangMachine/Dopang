package com.dopang.machine.equitytrading;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dopang.machine.equitytrading.mapper.UserMapper;

@SpringBootApplication
public class EquityTradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquityTradingApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public UserMapper userMapper() {
	    return new UserMapper();
	}

}
