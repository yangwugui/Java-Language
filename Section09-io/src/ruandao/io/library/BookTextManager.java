package ruandao.io.library;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import ruandao.io.*;

public class BookTextManager implements BookManager {
	private HashMap<String,Book> books;
	
	public BookTextManager() {
		books = new HashMap<String,Book>();
		init();
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#init()
	 */
	private void init() {
		add( new Book( "Asp.net ����") );
		add( new Book("Java ����") );
		add( new Book("Struts ����") );
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#guihuan(java.lang.String)
	 */
	@Override
	public int guihuan(String person, String bookName) throws Exception {
		Book book = books.get(bookName);
		if( book == null || !book.getBorrows().containsKey(person)){
			throw new Exception( "��Ǹ����Ҫ�����鲻���������ġ�");
		}
		
		Date now = new Date();
		int days = (int) ((now.getTime() - book.getBorrows().get(person).getStart().getTime()) / (24 * 60 * 60 * 1000));
		
		book.getBorrows().remove(person);
		book.setAmount(book.getAmount()+1);
		
		return days;
	}

	@Override
	public void borrow(String person, String bookName) throws Exception {
		Book book = books.get(bookName);
		if( book == null){
			throw new Exception( "��Ǹ��û���ҵ�������Ҫ���顣");
		}
		
		if( book.getAmount()==0){
			throw new Exception( "��Ǹ����Ҫ�����Ѿ��������ˣ��������������");
		}
		int amount = book.getAmount();
		book.setAmount(amount-1);
		int count = book.getCount();
		book.setCount(count + 1);
		book.getBorrows().put(person, new Borrow(person,book));
	}

	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#remove(java.lang.String)
	 */
	@Override
	public void remove(String name) throws Exception {
		Book book = books.get(name);
		if( book==null){
			throw new Exception( "��Ǹ�������û���Ȿ�顣");
		}
		
		if( book.getAmount()==0){
			throw new Exception( "��Ǹ���Ȿ���Ѿ�ȫ������ˣ��黹��������١�");
		}
		
		book.setAmount(book.getAmount()-1);
		
		// ���ͬһ��������Ϊ0����ô��ɾ���Ȿ�顣
		if( book.getAmount()==0 && book.getBorrows().size()==0 ){
			books.remove(name);
		}
	}

	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#list()
	 */
	@Override
	public String list() {
		String displayString = "";
		int i = 1;
		for(Book book : books.values()){
			displayString += i + ". " + book  + "\n";
			i++;
		}
		return displayString;
	}

	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#append(ruandao.collection.bookstore.Book)
	 */
	@Override
	public void add(Book book) {
		books.put(book.getName(), book);
	}
	
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
			Borrow b = new Borrow (person,book, start);
			book.getBorrows().put(person, b);
		}
	}
	
}
