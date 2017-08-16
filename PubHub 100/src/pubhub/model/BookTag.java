package pubhub.model;

public class BookTag {
	
	private String isbn13;
	private String bookTag;
	
	public BookTag(){
		
		this.isbn13=null;
		this.bookTag=null;
		
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public String getBookTag() {
		return bookTag;
	}
	public void setBookTag(String bookTag) {
		this.bookTag = bookTag;
	}

}
