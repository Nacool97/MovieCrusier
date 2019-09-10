package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.MoviesDao;
import com.cognizant.MovieCruiser.dao.MoviesDaoCollectionImpl;
import com.cognizant.MovieCruiser.model.Movies;

/**
 * Servlet implementation class ShowMovieListCustomerServlet
 */
@WebServlet(name = "ShowMovieListCustomerServlet", urlPatterns = { "/ShowMovieListCustomer" })
public class ShowMovieListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowMovieListCustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MoviesDao movieDao=new MoviesDaoCollectionImpl();
		try {
			ArrayList<Movies> movieList=movieDao.getMovieCustomer();
			request.setAttribute("x",movieList);
			RequestDispatcher rd= request.getRequestDispatcher("/movie-list-customer.jsp");
			rd.forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
