package com.example.springboot;

import java.util.Arrays;

import com.example.dto.OrderDTO;
import com.example.entity.Address;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			// for (String beanName : beanNames) {
			// 	System.out.println(beanName);
			// }

		};
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		// modelMapper.typeMap(OrderDTO.class, Address.class).addMappings(mapper -> {
		// 	mapper.map(src -> src.getUserDTO().getAddressDto().getLat(), DestinationSetter::setLat);
		// });

		modelMapper.typeMap(OrderDTO.class, Address.class).addMapping(src -> src.getUserDTO().getAddressDTO().getLat(), (dest, v) -> dest.setLat((String) v));
		modelMapper.typeMap(OrderDTO.class, Address.class).addMapping(src -> src.getUserDTO().getAddressDTO().getLon(), (dest, v) -> dest.setLon((String) v));
		return modelMapper;
	}

}
