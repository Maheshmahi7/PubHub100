package pubhub.dao;

import java.util.List;

import pubhub.model.Book;
import pubhub.model.BookTag;

public interface BookTagDAO {
	
	
	public boolean addTag(BookTag bookTag);
	public boolean removeTag(BookTag bookTag);
	public boolean getBook(BookTag bookTag);
	public List<Book> getBookByTag(String tag);

}
