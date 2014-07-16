

import java.io.IOException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import ruandao.bookstore.server.BookManager;

public class BookManagerTest {

	public static void main(String[] arg) 
			throws ParserConfigurationException, SAXException, IOException, ParseException{
        BookManager bm = new BookManager("Data Files/");
		
		System.out.println("size is: " + bm.getAllBooks().length);
		System.out.println("book title is: " + bm.fetchBook("888-7-2013-1").getTitle());
	}

}
