package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.MoviesDao;
import com.cognizant.MovieCruiser.dao.MoviesDaoCollectionImpl;
import com.cognizant.MovieCruiser.model.Movies;

@WebServlet(name = "ShowEditMovieServlet", urlPatterns = { "/ShowEditMovie" })
/**
 * Servlet implementation class ShowEditMovieServlet
 */
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEditMovieServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id =Long.parseLong( request.getParameter("id"));
		MoviesDao moviedao = new MoviesDaoCollectionImpl();
		Movies movie = moviedao.getMovie(id);
		System.out.println("show edit movie servlet active = "+movie.isActive());
	    request.setAttribute("x",movie);
		RequestDispatcher rd = request.getRequestDispatcher("/edit-movie.jsp");
		rd.forward(request,response);
	}

}
