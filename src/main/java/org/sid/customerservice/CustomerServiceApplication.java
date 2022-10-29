package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"Hamza","hamza@gmail.ma"));
			customerRepository.save(new Customer(null,"Hicham","hicham@gmail.ma"));
			customerRepository.save(new Customer(null,"Alaa","alaa@gmail.ma"));
			customerRepository.findAll().forEach(customer -> {
					System.out.println(customer.toString());
				}
			);
		};
	}
}
