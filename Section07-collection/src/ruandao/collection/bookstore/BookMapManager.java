package ruandao.collection.bookstore;

import java.util.*;

public class BookMapManager implements BookManager {
	private HashMap<String,Book> books;

	public BookMapManager( int max) {
		books = new HashMap<String,Book>();
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#init()
	 */
	@Override
	public void init() throws Exception{
		add( new Book( "Asp.net 入门") );
		add( new Book("Java 入门") );
		add( new Book("Struts 入门") );
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#guihuan(java.lang.String)
	 */
	@Override
	public void guihuan(String name) throws Exception {

		Book book = books.get(name);
		if( book == null ){
			throw new Exception( "抱歉，你要还的书不是在这儿借的。");
		}
		
		if( book.getState().equals("已还")){
			throw new Exception( "你已经还过这本书了，:)" );
		}
		book.setState ( "已还" );
	}

	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#borrow(java.lang.String)
	 */
	@Override
	public void borrow( String name) throws Exception {
		Book book = books.get(name);
		if( book == null){
			throw new Exception( "抱歉，没有找到你所需要的书。");
		}
		
		if( book.getState().equals("已借")){
			throw new Exception( "抱歉，你要的书已经被借走了，请过几天再来。");
		}
		
		book.setState( "已借");
		int count = book.getCount();
		book.setCount(count + 1);
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
		
		if( book.getState().equals("已借")){
			throw new Exception( "抱歉，这本书已经借出了，归还后才能销毁。");
		}
		
		books.remove(name);
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
	
}
