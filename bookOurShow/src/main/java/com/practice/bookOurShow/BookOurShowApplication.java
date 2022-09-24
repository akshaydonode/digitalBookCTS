package com.practice.bookOurShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookOurShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookOurShowApplication.class, args);
	}

}
