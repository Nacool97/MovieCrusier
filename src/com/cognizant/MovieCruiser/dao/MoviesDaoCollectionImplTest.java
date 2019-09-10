package com.cognizant.MovieCruiser.dao;
import java.text.SimpleDateFormat;
import java.util.*;

import com.cognizant.MovieCruiser.model.Movies;
import com.cognizant.MovieCruiser.util.DateUtil;


public class MoviesDaoCollectionImplTest{
	 
	
	static MoviesDao moviesDao=new MoviesDaoCollectionImpl(); 
	
	public static void testGetMovieListAdmin()
	{
		
		try
		{
			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
			ArrayList<Movies> movies = new ArrayList <Movies>();
			movies = moviesDao.getMovieListAdmin();
            System.out.println("Movie list for admin"); 
            System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Box Office","Active","Date Of Launch","Genre","Has Teaser"));   
			for (Movies items : movies) {

				System.out.println(items);

			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("----------*----------*----------*----------*----------");
	}
	public static void testGetMovieListCustomer()
	{
		


		try {

			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
			

			ArrayList<Movies> movies = new ArrayList<Movies>();

			movies = moviesDao.getMovieCustomer();

			System.out.println("Movie list for customer"); 

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Box Office","Active","Date Of Launch","Genre","Has Teaser"));

			for (Movies movie : movies) {

				System.out.println(movie);


			}

		} catch (Exception e) {

			System.out.println(e);

		}
		System.out.println("----------*----------*----------*----------*----------");
	}
	
	
			// TODO Auto-generated catch block

	public static void testmodifyMenuItem()
	{
		try {

			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
			Movies movies= new Movies((long) 01,"Avatar", "Science Fiction","2,488,456,152", true,true, DateUtil.convertToDate("02/11/2018"));
			ArrayList<Movies> movies1 = new ArrayList<Movies>();
			movies1 = moviesDao.getMovieCustomer();
			for(Movies x:movies1)
			{
			if(movies.getId()==x.getId()) {
			
			moviesDao.modifyMovie(movies);
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Box Office","Active","Date Of Launch","Genre","Has Teaser")); 

			System.out.println(movies);
			 System.out.println("Movie List Modified!");
 
			}
			}
			

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		System.out.println("----------*----------*----------*----------*----------");
	}
	
	public static void main(String[] args) throws FavouriteEmptyException
	{
		
		testGetMovieListAdmin();
		testGetMovieListCustomer();
        testmodifyMenuItem();
        testGetMovieListAdmin();
        testGetMovieListCustomer();
		
	}

	
}

