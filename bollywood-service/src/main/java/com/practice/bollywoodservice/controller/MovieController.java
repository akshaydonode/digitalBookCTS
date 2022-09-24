package com.practice.bollywoodservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bollywoodservice.entities.Movie;
import com.practice.bollywoodservice.services.MovieService;

@RestController
@CrossOrigin(origins = { "https://hoppscotch.io", "http://localhost:4200" })
@RequestMapping("/api/v1/movies")
public class MovieController {
	@Autowired
	private MovieService service;

	@GetMapping("")
	public List<Movie> getMovies() {
		return service.getAllMovies();
	}

	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable int id) throws Exception {
		return service.getMovieById(id);
	}

	@PostMapping("")
	public Movie saveMovie(@RequestBody Movie m) {
		return service.createMovie(m);
	}

	@GetMapping("/title") // ?title="batman is flying"
	public List<Movie> getMoviesByTitle(@RequestParam String title) {
		return service.getMoviesByTitle(title);
	}
}