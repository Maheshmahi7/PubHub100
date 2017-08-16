package pubhub.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pubhub.dao.BookTagDAO;
import pubhub.model.BookTag;
import pubhub.utilities.DAOUtilities;


public class AddBookTagServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		boolean isSuccess= false;
		String isbn13 = request.getParameter("isbn13");
		String tagName = request.getParameter("tag");
		BookTag book=new BookTag();
		book.setIsbn13(isbn13);
		book.setBookTag(tagName);
		// Grab the list of Books from the Database
		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		Boolean tag = dao.addTag(book);
		Boolean books = dao.getBook(book);
		if(books){
		if(tag){
			isSuccess=true;
		}
		// Populate the list into a variable that will be stored in the session
		if(isSuccess){
		request.getSession().setAttribute("message", "Book Tag Added Successfully");
		}
		else
		{
			request.getSession().setAttribute("message", "Book Tag Already Exists");
		}
		}
		else{
			request.getSession().setAttribute("message", "Entered ISBN number is Wrong");
		}
		
		request.getRequestDispatcher("addBookTag.jsp").forward(request, response);
	}

}
