package com.practice.bookOurShow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bookOurShow.clients.BollywoodMoviesClient;
import com.practice.bookOurShow.models.Show;

@RestController
@RequestMapping("/shows/api/v1")
public class ShowsController {
	
	@Autowired
	BollywoodMoviesClient bollywoodMoviesClient; 
	
	@GetMapping
	public List<Show> getDefaultShows() {
		List<Show> shows = new ArrayList<Show>();
		shows.add(new Show("Mahabharat", "Ram", 4.9));
		shows.add(new Show("Ramayan", "Valmiki", 4.7));
		return shows;
	}
	
	@GetMapping("/movies")
	public List<Show> getBollyWoodMovies(){
		List<Show> movies = bollywoodMoviesClient.getMovies();
		return movies;
	}
}
