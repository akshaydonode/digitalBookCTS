package com.practice.bollywoodservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.bollywoodservice.entities.Movie;
import com.practice.bollywoodservice.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repo;

	public Movie createMovie(Movie m) {
// validation - movie rating should not be negative
// validation - movie title and author should not be empty
		return repo.save(m);
	}

	public List<Movie> getAllMovies() {
// logic
		return repo.findAll();
	}

	public Movie getMovieById(int id) throws Exception {
// logic
		Optional<Movie> optional = repo.findById(id);
		if (optional.isEmpty()) {
			System.out.println("Movie with id (" + id + ") not found in db");
			throw new Exception("Movie with id (" + id + ") not found in db");
		} else {
			return optional.get();
		}
	}

// find movies by title
	public List<Movie> getMoviesByTitle(String title) {
		System.out.println("Finding by title : " + title);
		if (title != null && title.length() != 0) {
			return repo.findByTitle(title);
		} else {
			return getAllMovies();
		}
	}
// update movie
// delete movie
}
