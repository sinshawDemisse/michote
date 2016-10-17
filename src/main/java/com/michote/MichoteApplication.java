package com.michote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.michote")
public class MichoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MichoteApplication.class, args);
	}
}
