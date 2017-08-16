package pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pubhub.dao.BookTagDAO;
import pubhub.model.Book;
import pubhub.utilities.DAOUtilities;

public class SelectBookByTagServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		String tag = request.getParameter("tag");
	

		List<Book> book = dao.getBookByTag(tag);
		
		for(Book books : book) {
            System.out.println(books.getIsbn13());
            System.out.println(books.getTitle());
            System.out.println(books.getAuthor());
            System.out.println(books.getPublishDate());
            System.out.println(books.getPrice());
        }
		
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		String tag = request.getParameter("tag");
	

		List<Book> book = dao.getBookByTag(tag);
		
		for(Book books : book) {
            System.out.println(books.getIsbn13());
            System.out.println(books.getTitle());
            System.out.println(books.getAuthor());
            System.out.println(books.getPublishDate());
            System.out.println(books.getPrice());
        }
		
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
		
	}

}
