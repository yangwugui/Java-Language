package ruandao.io.library;

import java.io.*;
import java.text.*;
import java.util.*;

import ruandao.io.*;

public class BookObjectManager implements BookManager {

	private HashMap<String,Book> books;
	
	public BookObjectManager() {
		books = new HashMap<String,Book>();
		init();
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#init()
	 */
	private void init() {
		add( new Book( "Asp.net 入门") );
		add( new Book("Java 入门") );
		add( new Book("Struts 入门") );
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#guihuan(java.lang.String)
	 */
	@Override
	public int guihuan(String person, String bookName) throws Exception {
		Book book = books.get(bookName);
		if( book == null || !book.getBorrows().containsKey(person)){
			throw new Exception( "抱歉，你要还的书不是在这儿借的。");
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
			throw new Exception( "抱歉，没有找到你所需要的书。");
		}
		
		if( book.getAmount()==0){
			throw new Exception( "抱歉，你要的书已经被借走了，请过几天再来。");
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
			throw new Exception( "抱歉，书库中没有这本书。");
		}
		
		if( book.getAmount()==0){
			throw new Exception( "抱歉，这本书已经全部借出了，归还后才能销毁。");
		}
		
		book.setAmount(book.getAmount()-1);
		
		// 如果同一本的数量为0，那么就删除这本书。
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
		FileOutputStream fos = new FileOutputStream("d:\\books.dat");
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
		FileInputStream fis = new FileInputStream("d:\\books.dat");
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
