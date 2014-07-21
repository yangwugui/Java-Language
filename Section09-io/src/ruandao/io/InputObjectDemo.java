package ruandao.io;

import java.io.*;
import java.util.ArrayList;

public class InputObjectDemo {

	public static void main(String[] args) 
			throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Data Files/books.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		ArrayList<Book> books;
		
		try{
			books = (ArrayList<Book>)ois.readObject();
			for( Book book : books){
				System.out.println( book );
			}
		}
		finally{
			ois.close();
			fis.close();
		}

	}

}
