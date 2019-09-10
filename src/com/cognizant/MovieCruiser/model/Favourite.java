package com.cognizant.MovieCruiser.model;

import java.util.ArrayList;
public class Favourite {
	
	private double total;
	private ArrayList<Movies> movieList;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<Movies> getMovieList() { 
		return movieList;
	}
	public void setMovieList(ArrayList<Movies> movieList) {
		this.movieList = movieList;
	}
	public Favourite(double total, ArrayList<Movies> movieList) 
	{
		this.total = total;
		this.movieList = movieList;
	}
	@Override
	public String toString() {
		return String.format("%-25s$%-25s%-25s%-25s%-25s%-20s\n",getMovieList(),getTotal());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favourite other = (Favourite) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

}
