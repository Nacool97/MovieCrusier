package com.cognizant.MovieCruiser.dao;

import java.util.*;
import com.cognizant.MovieCruiser.model.Movies;
import com.cognizant.MovieCruiser.util.DateUtil;
public class MoviesDaoCollectionImpl implements MoviesDao 
{
   private static ArrayList<Movies> movieList;
   public MoviesDaoCollectionImpl() 
   {
	   
	   super();
	   if(movieList == null || movieList.isEmpty())
	   {
		   movieList = new ArrayList<Movies>();
		   try
		   {
		   movieList.add(new Movies((long) 01, "Avatar", "Science Fiction","2,787,965,087", true,true,DateUtil.convertToDate("15/03/2017")));

		   movieList.add(new Movies((long) 02, "Avengers", "Superhero","1,518,812,988", true,false,DateUtil.convertToDate("23/12/2017")));

		   movieList.add(new Movies((long) 03, "Titanic","Romance", "2,187,463,944", true,false ,DateUtil.convertToDate("21/08/2018")));

		   movieList.add(new Movies((long) 04, "Jurassic world","Science Fiction","1,671,713,208", false,true,DateUtil.convertToDate("02/07/2017")));

			movieList.add(new Movies((long) 05, "Avenger:End game", "Superhero","2,750,760,348", true,true,DateUtil.convertToDate("02/11/2022")));
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
	   }
   }

public ArrayList<Movies> getMovieListAdmin() {
	
	// TODO Auto-generated method stub
	return movieList;
}

public ArrayList<Movies> getMovieCustomer() throws Exception {
	
	ArrayList<Movies> fil = new ArrayList<Movies>();
	for(Movies x:movieList)
	{
		Date d = x.getDateOfLaunch();
		String today = "19/08/2019";
		Date tdate = DateUtil.convertToDate(today);
		if(d.before(tdate) || d.equals(tdate))
		{
			if(x.isActive())
			{
				fil.add(x);
			}
		}
	}
	return fil;
	
}


public void modifyMovie(Movies movies) {
	// TODO Auto-generated method stub
	for(Movies x:movieList)
	{
		if(x.getId()==movies.getId())
		{
			x.settitle(movies.gettitle());
			x.setActive(movies.isActive());
			x.setgenre(movies.getgenre());
			x.setDateOfLaunch(movies.getDateOfLaunch());
			x.setgenre(movies.getgenre());
			x.setHasTeaser(movies.isHasTeaser());
			x.setBoxOffice(movies.getBoxOffice());
		}
	}
	
}

public Movies getMovie(long movieId) {
	// TODO Auto-generated method stub
	for(Movies x: movieList)
	{
		if(x.getId()== movieId)
		{
			return x;
		}
	}
	return null;
}








}
