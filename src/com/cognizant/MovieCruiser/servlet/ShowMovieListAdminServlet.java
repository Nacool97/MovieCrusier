package com.cognizant.MovieCruiser.servlet;
import com.cognizant.MovieCruiser.dao.*;
import com.cognizant.MovieCruiser.model.Movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowMovieListAdminServlet
 */
@WebServlet(name = "ShowMovieListAdminServlet", urlPatterns = { "/ShowMovieListAdmin" })
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowMovieListAdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	//	PrintWriter out=response.getWriter();
		response.setContentType("html/text");
		MoviesDao movieDao=new MoviesDaoCollectionImpl();
		ArrayList<Movies> movieList=movieDao.getMovieListAdmin();
	
		request.setAttribute("x", movieList);
		RequestDispatcher rd=request.getRequestDispatcher("/movie-list-admin.jsp");
		rd.forward(request,response);
	}

}
