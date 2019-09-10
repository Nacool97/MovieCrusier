package com.cognizant.MovieCruiser.dao;

import java.util.*;
import java.util.ArrayList;

import com.cognizant.MovieCruiser.dao.FavouriteEmptyException;
import com.cognizant.MovieCruiser.model.Favourite;
import com.cognizant.MovieCruiser.model.Movies;


public class FavouriteDaoCollectionImpl implements FavouriteDao {
	private static HashMap<Long,Favourite> userFavourites;
	public static int count;
	public FavouriteDaoCollectionImpl()
	{
		if(userFavourites == null)
		{
			userFavourites = new  HashMap<Long,Favourite>();
			
		}
	}

	public void addFavourites(long userId, Long movieId) {
		
		try
		{
			MoviesDao moviesDao = new MoviesDaoCollectionImpl();
			Movies Movies = moviesDao.getMovie(movieId);
			if(userFavourites.containsKey(userId))
			{
				ArrayList<Movies> Favourites = userFavourites.get(userId).getMovieList();
			    Favourites.add(Movies);
				
			}
			else
			{
				ArrayList <Movies> FavouriteMenu = new ArrayList<Movies>();
				FavouriteMenu.add(Movies);
				Favourite newFavourite = new Favourite(0,FavouriteMenu);
				userFavourites.put(userId,newFavourite);
				
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}

	public ArrayList<Movies> getAllFavourites(long userId) throws FavouriteEmptyException {

		ArrayList <Movies> getAll = userFavourites.get(userId).getMovieList();
		if(getAll.isEmpty())
		{
			throw new FavouriteEmptyException("favourites is empty");
			
		}
		else
		{
			float value =0.00f;
			count=0;
			for(@SuppressWarnings("unused") Movies x : getAll)
			{
			
				count++;
			}
			userFavourites.get(userId).setTotal(value);
			return getAll;
		}
		
	}

	public void removeFavourites(long userId, long MoviesId) {
		
		
		ArrayList <Movies> removeList = userFavourites.get(userId).getMovieList();
		for(Movies x: removeList)
		{
			if(x.getId() == MoviesId)
			{
				
				removeList.remove(removeList.indexOf(x));
				break;
			}
		}
		userFavourites.get(userId).setMovieList(removeList);
		count--;
	}

	

}