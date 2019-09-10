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
 * Servlet implementation class RemoveFavouriteServlet
 */
@WebServlet(name = "RemoveFavourite", urlPatterns = { "/RemoveFavourite" })
public class RemoveFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RemoveFavouriteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long id=Long.parseLong(request.getParameter("id"));
		long userId=1;
		FavouriteDao favDao=new FavouriteDaoCollectionImpl();
		favDao.removeFavourites(userId,id);
		try {
			ArrayList<Movies> movieList=favDao.getAllFavourites(userId);
			boolean rmStatus=true;
			int count=FavouriteDaoCollectionImpl.count;
			request.setAttribute("x",movieList);
			request.setAttribute("rm",rmStatus);
			request.setAttribute("count1",count);
			
			RequestDispatcher rd=request.getRequestDispatcher("/favourites.jsp");
			rd.forward(request,response);
		
		} catch (FavouriteEmptyException e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd=request.getRequestDispatcher("/favourites-empty.jsp");
			rd.forward(request,response);
			e.printStackTrace();
		}
	}

}
