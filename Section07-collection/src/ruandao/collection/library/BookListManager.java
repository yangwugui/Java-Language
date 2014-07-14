package ruandao.collection.library;

import java.util.ArrayList;

public class BookListManager implements BookManager {
	private ArrayList<Book> books;

	public BookListManager() {
		books = new ArrayList<Book>();
		init();
	}
	
	private void init(){
		add( new Book( "Asp.net 入门") );
		add( new Book("Java 入门") );
		add( new Book("Struts 入门") );
	}

	public Book getBook(String name){
		Book book = null;
		for( Book item : books){
			if( name.equals(book.getName())){
				book = item;
			}
		}
		return book;
	}
	
	public void guihuan(String name) throws Exception {
		Book book = getBook(name);
		if( book==null){
			throw new Exception( "抱歉，你要还的书不是在这儿借的。");
		}
		
		if( book.getState().equals("已还")){
			throw new Exception( "你已经还过这本书了，:)" );
		}
		book.setState ( "已还" );
	}

	public void borrow( String name) throws Exception {
		Book book = getBook(name);
		if( book == null ){
			throw new Exception( "抱歉，没有找到你所需要的书。");
		}

		if( book.getState().equals("已借")){
			throw new Exception( "抱歉，你要的书已经被借走了，请过几天再来。");
		}
		
		book.setState( "已借");
		int count = book.getCount();
		book.setCount(count + 1);
	}

	public void remove(String name) throws Exception {
		Book book = getBook(name);
		if( book==null ){
			throw new Exception( "抱歉，书库中没有这本书。");
		}

		if( book.getState().equals("已借")){
			throw new Exception( "抱歉，这本书已经借出了，归还后才能销毁。");
		}
		
		books.remove(book);
	}

	public String list() {
		String displayString = "";
		int i = 1;
		for(Book book : books){
			displayString += i + ". " + book + "\r\n" ;
			i++;
		}
		return displayString;
	}

	public void add(Book book) {
		books.add(book);
	}
	
}
