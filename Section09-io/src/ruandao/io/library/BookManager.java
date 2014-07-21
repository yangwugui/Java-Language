package ruandao.io.library;

import java.util.Date;
import java.util.HashMap;

import ruandao.io.*;

public abstract class BookManager {

	protected HashMap<String,Book> books;
	
	public BookManager() {
		books = new HashMap<String,Book>();
	}
	
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
		book.getBorrows().put(person, new Borrow(person));
	}

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

	public void add(Book book) {
		books.put(book.getName(), book);
	}

	public Book[] getAllBooks() {
		return this.books.values().toArray(new Book[0]);
	}

	public abstract void save(String name) throws Exception;
	
	public abstract void open(String filename) throws Exception;
}