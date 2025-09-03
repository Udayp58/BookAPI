package resources;

import pojo.AddBook;

public class TestData {

	public AddBook getAddBookPayload(String isbn, String aisle)
	{
		AddBook b = new AddBook();
		
		b.setName("Learn Rest Assured API Testing");
		b.setAuthor("Uday Khushal Patil");
		b.setIsbn(isbn);
		b.setAisle(aisle);
		
		return b;
		
		
	}
	
}
