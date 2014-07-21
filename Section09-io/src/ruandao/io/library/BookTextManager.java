package ruandao.io.library;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import ruandao.io.*;

public class BookTextManager extends BookManager {

	
	public void save(String filename) 
			throws IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try(BufferedWriter bw = new BufferedWriter
				( new FileWriter(filename) ) ){
			for(Book book : books.values()){
				bw.write("[Book]\n");
				bw.write("name=" + book.getName() + "\n");
				bw.write("amount=" + book.getAmount() + "\n");
				bw.write("count=" + book.getCount() + "\n");
				for(Borrow borrow : book.getBorrows().values()){
					bw.write("borrow=" + sdf.format(borrow.getStart()) + "," + borrow.getPerson() + "\n");
				}
			}
		}
		
	}
	
	public void open(String filename) 
			throws Exception{
		try( BufferedReader br = new BufferedReader(
				new FileReader(filename) )){
			String line = br.readLine();
			boolean isParsing = false;
			Book book = null;
			while(line!=null){
				
				if(line.startsWith("[Book]")){
					if( isParsing ){
						books.put(book.getName(), book);
					}
					isParsing = true;
					book = new Book();
				} // if start book
				if(isParsing){
					parseBook(line, book);
				} // if(isParsing)
				line = br.readLine();
			} // end while
			if(isParsing){
				books.put(book.getName(), book);
			}
			
		} // try
	} // method

	private void parseBook(String line, Book book)
			throws ParseException {
		
		if(line.startsWith("name=")){
			book.setName(line.substring(5));
		}
		if(line.startsWith("amount=")){
			book.setAmount(Integer.parseInt(line.substring(7)) );
		}
		if(line.startsWith("count=")){
			book.setCount(Integer.parseInt(line.substring(6)) );
		}
		if(line.startsWith("borrow=")){
			String s = line.substring(7);
			String person = s.substring(11);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date start = sdf.parse(s.substring(0,11));
			Borrow b = new Borrow (person, start);
			book.getBorrows().put(person, b);
		}
	}
	
}
