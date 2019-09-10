package com.cognizant.MovieCruiser.dao;

import java.text.SimpleDateFormat;
import java.util.*;

import com.cognizant.MovieCruiser.dao.FavouriteDao;
import com.cognizant.MovieCruiser.dao.FavouriteEmptyException;
import com.cognizant.MovieCruiser.model.*;

public class FavouriteDaoCollectionImplTest {
	static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/YYYY");
	
	public static void testAddFavourite()
	{
		FavouriteDao favouriteDao = new FavouriteDaoCollectionImpl();
		favouriteDao.addFavourites((long)1, (long) 2);
		try
		{	
		
			ArrayList<Movies> favList = favouriteDao.getAllFavourites((long)1);
			System.out.println("Movie added to favourites successfully");
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","title","Box Office","Active","Date Of Launch","Genre","HasTeaser"));
			for (Movies item : favList) {
				System.out.println(item);
			}			
		}
		catch(FavouriteEmptyException e)
		{
			System.out.println(e);
		}
		
		System.out.println("----------*----------*----------*----------*----------*----------*----------*----------");
		
	}
	public static void testgetAllFavourites()
	{
		FavouriteDao favDao = new FavouriteDaoCollectionImpl();
		try
		{
		 ArrayList<Movies> favmovies = favDao.getAllFavourites((long)1);
		 System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Box Office","Active","Date Of Launch","Genre","Has Teaser"));
		 for(Movies item:favmovies)
		 {
			 System.out.println(item);
		 }
		 System.out.println("Number of favourite movies "+FavouriteDaoCollectionImpl.count);
		}
		catch(FavouriteEmptyException e)
		{
			e.getMessage();
		}
		System.out.println("----------*----------*----------*----------*----------*----------*----------*----------");
	}
	public static void testRemoveFavourites()
	{
		System.out.println("Movie deleted from favourites successfully");
		
		FavouriteDao favDao = new FavouriteDaoCollectionImpl();
		favDao.removeFavourites((long)1,(long)2);
		try
		{
			ArrayList<Movies> favLefts = favDao.getAllFavourites((long)1); 
			if(favLefts.isEmpty())
			{
				throw new FavouriteEmptyException("favourites is empty");
			}
			else
			{
				for(Movies item:favLefts)
				{
					System.out.println(item);
				}
			}
		}
		catch(FavouriteEmptyException e)
		{
			System.out.println(e);
		}
		System.out.println("----------*----------*----------*----------*----------*----------*----------*----------");
	}
	
	public static void main(String[] args) 
	{
		testAddFavourite();
		testgetAllFavourites();
		testRemoveFavourites();
	
	}

	
}
