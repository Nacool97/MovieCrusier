package com.cognizant.MovieCruiser.model;

import java.text.SimpleDateFormat;
import java.util.*;


public class Movies {

	private long id;
	private String title,genre;
	private String BoxOffice;
	private boolean active,HasTeaser;
	private Date dateOfLaunch;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getgenre() {
		return genre;
	}
	public void setgenre(String genre) {
		this.genre = genre;
	}
	public String getBoxOffice() {
		return BoxOffice;
	}
	public void setBoxOffice(String BoxOffice) {
		this.BoxOffice = BoxOffice;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isHasTeaser() {
		return HasTeaser;
	}
	public void setHasTeaser(boolean HasTeaser) {
		this.HasTeaser = HasTeaser;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	public Movies()
	{
		
	}
   public Movies(long id, String title, String genre, String BoxOffice, boolean active, boolean HasTeaser,Date dateOfLaunch) 
   {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.BoxOffice = BoxOffice;
		this.active = active;
		this.HasTeaser = HasTeaser;
		this.dateOfLaunch = dateOfLaunch;
	}

public boolean equals(Movies obj)
	{
		if(obj instanceof Movies)
		{		
		  Movies p3 = (Movies)obj;
		
	      return(this.id==p3.id);
		}
		return false;
	}
@Override
public String toString() {
	SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
	return String.format("%-25s$%-25s%-25s%-25s%-25s%-20s\n",gettitle(),getBoxOffice(),isActive(),simple.format(getDateOfLaunch()),getgenre(),isHasTeaser());
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Movies other = (Movies) obj;
	if (HasTeaser != other.HasTeaser)
		return false;
	if (active != other.active)
		return false;
	if (dateOfLaunch == null) {
		if (other.dateOfLaunch != null)
			return false;
	} else if (!dateOfLaunch.equals(other.dateOfLaunch))
		return false;
	if (genre == null) {
		if (other.genre != null)
			return false;
	} else if (!genre.equals(other.genre))
		return false;
	if (BoxOffice.equals(this.BoxOffice))
		return true;
	
	if (id != other.id)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
  
	
}
