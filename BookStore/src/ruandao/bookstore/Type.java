package ruandao.bookstore;

import java.util.ArrayList;

public enum Type {
	JAVA(1,"Java"), 
	DOTNET(2,".Net"),
	PHP(3,"Php"),
	HTML5(4,"Html5"),
	ANDROID(5,"Android");
	
	private int id;
	private String title;

	private Type(int id, String title){
		this.id = id;
		this.title = title;
	}
	
	public ArrayList<Book> getBooks(){
		ArrayList<Book> books = new ArrayList<Book>();
		
		return books;
	}
}
