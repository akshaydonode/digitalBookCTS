package com.practice.bookOurShow.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.practice.bookOurShow.models.Show;

@FeignClient("BOLLYWOOD-MOVIES")
public interface BollywoodMoviesClient {

	@GetMapping("/api/v1/movies")
	List<Show> getMovies();
}
