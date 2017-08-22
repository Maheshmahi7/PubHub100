package pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pubhub.model.Book;
import pubhub.model.BookTag;
import pubhub.utilities.DAOUtilities;

public class BookTagDAOImpl implements BookTagDAO{
	
	
	private Connection connection = null;	// Our connection to the database
	private PreparedStatement stmt = null;	// We use prepared statements to help protect against SQL injection

	
	public List<Book> getBookByTag(String tag) {
		
		List<Book> books = new ArrayList<>();

		try {
			connection = DAOUtilities.getConnection();	// Get our database connection from the manager
			String sql = "SELECT b.isbn_13, b.title, b.author, b.publish_date, b.price FROM books b JOIN book_tags bt ON b.isbn_13=bt.`isbn_13` WHERE bt.`tag_name`=?";			// Our SQL query
			stmt = connection.prepareStatement(sql);	// Creates the prepared statement from the query
			
			stmt.setString(1, tag);

			
			ResultSet rs = stmt.executeQuery();			// Queries the database

			// So long as the ResultSet actually contains results...
		
			while (rs.next()) {
				Book book=new Book();

				book.setIsbn13(rs.getString("isbn_13"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublishDate(rs.getDate("publish_date").toLocalDate());
				book.setPrice(rs.getDouble("price"));
				books.add(book);
			}
		
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// We need to make sure our statements and connections are closed, 
			// or else we could wind up with a memory leak
			closeResources();
		}
		
		// return the list of Book objects populated by the DB.
		return books;
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public boolean addTag(BookTag bookTag) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO book_tags VALUES (?, ?)"; // Were using a lot of ?'s here...
			stmt = connection.prepareStatement(sql);
			
			// But that's okay, we can set them all before we execute
			stmt.setString(1, bookTag.getIsbn13());
			stmt.setString(2, bookTag.getBookTag());
			
			// If we were able to add our book to the DB, we want to return true. 
			// This if statement both executes our query, and looks at the return 
			// value to determine how many rows were changed
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public boolean removeTag(BookTag bookTag) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM book_tags WHERE isbn_13=? AND tag_name=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,bookTag.getIsbn13());
			stmt.setString(2,bookTag.getBookTag());

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}

	
	/*------------------------------------------------------------------------------------------------*/

	public boolean getBook(BookTag bookTag) {
		Boolean result=false;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT isbn_13 FROM books WHERE isbn_13=?"; // Were using a lot of ?'s here...
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, bookTag.getIsbn13());
			

			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				 result=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result=false;
		} finally {
			closeResources();
		}
		return result;
	}

	
	/*------------------------------------------------------------------------------------------------*/


	// Closing all resources is important, to prevent memory leaks. 
	// Ideally, you really want to close them in the reverse-order you open them
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
	
	/*------------------------------------------------------------------------------------------------*/


}
