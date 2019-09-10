package com.cognizant.MovieCruiser.util;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class DateUtil {

	public static Date convertToDate(String s) 
	{
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");

		Date date1=null;
		try {
			date1 = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date1;
		
	}
}
