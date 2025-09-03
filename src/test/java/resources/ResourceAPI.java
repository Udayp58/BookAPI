package resources;

public enum ResourceAPI {

	AddBookAPI("Library/Addbook.php"),
	GetBookAPI("Library/GetBook.php");
	

	private String resource;

	ResourceAPI(String resource) {

		this.resource = resource;

	}

	public String getResourceUrl() {
		
		return resource;

	}

}
