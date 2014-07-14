package ruandao.bookstore;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ruandao.bookstore.Book;
import ruandao.bookstore.BookManager;

public class BookManagerTest {

	public static void main(String[] arg) 
			throws ParserConfigurationException, SAXException, IOException, ParseException{
		BookManager bm = new BookManager("D:/Course/Java Language/Source Workspace/BookStore/Book Files/");
		
		System.out.println("size is: " + bm.allBooks.size());
		System.out.println("book title is: " + bm.fetchBook("888-7-2013-1").getTitle());
		
		System.out.println(bm.getBookXmlFile());
	}

}
