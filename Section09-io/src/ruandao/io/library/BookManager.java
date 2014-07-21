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
			throw new Exception( "��Ǹ����Ҫ�����鲻���������ġ�");
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
			throw new Exception( "��Ǹ��û���ҵ�������Ҫ���顣");
		}
		
		if( book.getAmount()==0){
			throw new Exception( "��Ǹ����Ҫ�����Ѿ��������ˣ��������������");
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

	public void add(Book book) {
		books.put(book.getName(), book);
	}

	public Book[] getAllBooks() {
		return this.books.values().toArray(new Book[0]);
	}

	public abstract void save(String name) throws Exception;
	
	public abstract void open(String filename) throws Exception;
}