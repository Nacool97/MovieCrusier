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
import com.cognizant.MovieCruiser.dao.MoviesDao;
import com.cognizant.MovieCruiser.dao.MoviesDaoCollectionImpl;
import com.cognizant.MovieCruiser.model.Movies;

/**
 * Servlet implementation class AddToFavouriteServlet
 */
@WebServlet(name = "AddToFavourite", urlPatterns = { "/AddToFavourite" })
public class AddToFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddToFavouriteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id =Long.parseLong( request.getParameter("id"));
	    FavouriteDao favoritedao = new FavouriteDaoCollectionImpl();
	    long userId = 1;
	    MoviesDao Moviedao=new MoviesDaoCollectionImpl();
		ArrayList<Movies> movielist;
		try {
			movielist = Moviedao.getMovieCustomer();
			 favoritedao.addFavourites(userId, id);
			    boolean addfav = true;
			    request.setAttribute("fav",addfav);
			    request.setAttribute("x", movielist);
			    RequestDispatcher rd = request.getRequestDispatcher("/movie-list-customer.jsp");
				rd.forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

}
