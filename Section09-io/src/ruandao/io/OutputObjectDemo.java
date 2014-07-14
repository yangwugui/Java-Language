package ruandao.io;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class OutputObjectDemo{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) 
			throws IOException {
		FileOutputStream fos = new FileOutputStream("d:\\books.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		ArrayList<Book> books = new ArrayList<Book> ();
		
		Book book;
		
		book = new Book("高效能人士的七个习惯");
		book.getBorrows().put("coolman", new Borrow("coolman",book,new Date()));
		book.setAmount(9);
		book.setCount(5);
		books.add(book);
		
		book = new Book("古文观止");
		book.getBorrows().put("yangwugui", new Borrow("yanwugui",book,new Date()));
		book.setAmount(9);
		book.setCount(1);
		books.add(book);
		
		try{
			oos.writeObject(books);
		
		}
		finally{
			oos.close();
			fos.close();
		}
	}

}
