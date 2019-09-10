package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.MoviesDao;
import com.cognizant.MovieCruiser.dao.MoviesDaoCollectionImpl;
import com.cognizant.MovieCruiser.model.Movies;
import com.cognizant.MovieCruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet(name = "EditMovieServlet", urlPatterns = { "/EditMovie" })
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditMovieServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long id=Long.parseLong(request.getParameter("id"));
		String title=request.getParameter("title");
		String boxOffice=request.getParameter("price");
		String genre=request.getParameter("genre");
		Date dateOfLaunch=DateUtil.convertToDate(request.getParameter("dateOfLaunch"));
		boolean active=Boolean.parseBoolean(request.getParameter("active"));
		System.out.println("active = "+active);
		boolean hasTeaser=Boolean.parseBoolean(request.getParameter("HasTeaser"));
		System.out.println("Has Teaser :"+hasTeaser);
		Movies movies=new Movies();
		doGet(request,response);
		movies.setId(id);
		movies.settitle(title);
		movies.setBoxOffice(boxOffice);
		movies.setgenre(genre);
		movies.setDateOfLaunch(dateOfLaunch);
		movies.setActive(active);
		movies.setHasTeaser(hasTeaser);
		MoviesDao movieDao=new MoviesDaoCollectionImpl();
		movieDao.modifyMovie(movies);
		RequestDispatcher rd=request.getRequestDispatcher("/edit-movie-status.jsp");
		rd.forward(request,response);
		
	}

}
