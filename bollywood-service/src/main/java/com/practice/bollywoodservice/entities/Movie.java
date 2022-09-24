package com.practice.bollywoodservice.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // optional
	private int id;
	private String title;
	private String director;
	private double rating;
	private LocalDate releasedDate;

	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", rating=" + rating
				+ ", releasedDate=" + releasedDate + "]";
	}

	public Movie() {
		super();
		this.releasedDate = LocalDate.now();
	}

	public Movie(int id, String title, String director, double rating) {
		this(title, director, rating);
		this.id = id;
	}

	public Movie(String title, String director, double rating) {
		this();
		this.title = title;
		this.director = director;
		this.rating = rating;
	}
}
