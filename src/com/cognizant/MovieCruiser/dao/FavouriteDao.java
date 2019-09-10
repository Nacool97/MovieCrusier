package com.cognizant.MovieCruiser.dao;

import java.util.*;

import com.cognizant.MovieCruiser.model.Movies;

public interface FavouriteDao {

	public void addFavourites(long userId,Long movieId);
	public ArrayList<Movies> getAllFavourites(long userId) throws FavouriteEmptyException;
	public void removeFavourites(long userId,long movieId);
}
