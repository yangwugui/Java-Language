package ruandao.io.library;

import java.io.*;
import java.text.*;
import java.util.*;

import ruandao.io.*;

public class BookObjectManager extends BookManager {
	public void save(String filename) 
			throws IOException{
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		try{
			oos.writeObject(books);
		}
		finally{
			oos.close();
			fos.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void open(String filename) 
			throws Exception{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);

		
		try{
			books = (HashMap<String,Book>)ois.readObject();
		}
		finally{
			ois.close();
			fis.close();
		}

	} // method
}
