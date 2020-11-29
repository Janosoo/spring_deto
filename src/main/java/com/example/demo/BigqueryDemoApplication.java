package com.example.demo;

import javax.transaction.Transactional;
import com.example.demo.testingBq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BigqueryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigqueryDemoApplication.class, args);
	}
	
	@Bean
	@Transactional
	public CommandLineRunner demo(testingBq testingbq) {
	  return (args) -> {
		  
		  testingBq.simpleQuery();
	  };
		  
	  }

}



