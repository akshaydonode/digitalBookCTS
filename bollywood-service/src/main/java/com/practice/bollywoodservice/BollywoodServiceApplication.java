package com.practice.bollywoodservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.bollywoodservice.entities.Movie;
import com.practice.bollywoodservice.services.MovieService;

@SpringBootApplication
public class BollywoodServiceApplication implements CommandLineRunner {
	@Autowired
	private MovieService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Service: " + service);
		service.createMovie(new Movie("Spiderman is back", "Miley", 3.9));
		service.createMovie(new Movie("Batman is bright", "Carl", 4.9));
		service.createMovie(new Movie("Ironman is on fire", "Tom", 4.8));
		service.createMovie(new Movie("Antman is not ant", "John", 4.2));
	}

	public static void main(String[] args) {
		SpringApplication.run(BollywoodServiceApplication.class, args);
	}
}
