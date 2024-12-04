package com.naveen.lazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//main method
@SpringBootApplication
public class SpringBootLazyInitExampleApplication {

	public static void main(String[] args) {
		//a
		SpringApplication.run(SpringBootLazyInitExampleApplication.class, args);
		//b
	}

}
