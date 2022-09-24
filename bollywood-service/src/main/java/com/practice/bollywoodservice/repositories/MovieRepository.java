package com.practice.bollywoodservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.bollywoodservice.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query(nativeQuery = false, value = "select m from Movie m where m.title like %?1%")
	List<Movie> findByTitle(String title);
}
