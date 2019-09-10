package com.cognizant.MovieCruiser.dao;

import java.util.*;

import com.cognizant.MovieCruiser.model.Movies;


public interface MoviesDao {
	
 public ArrayList<Movies> getMovieListAdmin();
 public ArrayList<Movies> getMovieCustomer() throws Exception;
 public void modifyMovie(Movies movies);
 public Movies getMovie(long movieId);
 
}
