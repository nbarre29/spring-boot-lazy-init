package com.naveen.lazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLazyInitExampleApplication {

	public static void main(String[] args) {
		//A
		SpringApplication.run(SpringBootLazyInitExampleApplication.class, args);
		//B
	}

}
