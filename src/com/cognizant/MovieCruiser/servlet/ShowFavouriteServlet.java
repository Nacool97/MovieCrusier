package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.FavouriteDao;
import com.cognizant.MovieCruiser.dao.FavouriteDaoCollectionImpl;
import com.cognizant.MovieCruiser.dao.FavouriteEmptyException;
import com.cognizant.MovieCruiser.model.Movies;

/**
 * Servlet implementation class ShowFavouriteServlet
 */
@WebServlet(name = "ShowFavourite", urlPatterns = { "/ShowFavourite" })
public class ShowFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowFavouriteServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FavouriteDao favoritedao = new FavouriteDaoCollectionImpl();
		long userId =1;
		//long id = Long.parseLong(request.getParameter("id"));
		try {
			ArrayList<Movies> favourites=favoritedao.getAllFavourites(userId);
			int count = FavouriteDaoCollectionImpl.count;
			request.setAttribute("count1",count);
			request.setAttribute("x",favourites);
			RequestDispatcher re = request.getRequestDispatcher("/favourites.jsp");
			re.forward(request,response);
		} catch (FavouriteEmptyException e) {
			// TODO Auto-generated catch block
			RequestDispatcher re = request.getRequestDispatcher("/favourites-empty.jsp");
			re.forward(request,response);
			e.printStackTrace();
		}
	}

}
