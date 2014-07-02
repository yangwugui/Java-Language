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
		add( new Book( "Asp.net ����") );
		add( new Book("Java ����") );
		add( new Book("Struts ����") );
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#guihuan(java.lang.String)
	 */
	@Override
	public void guihuan(String name) throws Exception {

		Book book = books.get(name);
		if( book == null ){
			throw new Exception( "��Ǹ����Ҫ�����鲻���������ġ�");
		}
		
		if( book.getState().equals("�ѻ�")){
			throw new Exception( "���Ѿ������Ȿ���ˣ�:)" );
		}
		book.setState ( "�ѻ�" );
	}

	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#borrow(java.lang.String)
	 */
	@Override
	public void borrow( String name) throws Exception {
		Book book = books.get(name);
		if( book == null){
			throw new Exception( "��Ǹ��û���ҵ�������Ҫ���顣");
		}
		
		if( book.getState().equals("�ѽ�")){
			throw new Exception( "��Ǹ����Ҫ�����Ѿ��������ˣ��������������");
		}
		
		book.setState( "�ѽ�");
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
			throw new Exception( "��Ǹ�������û���Ȿ�顣");
		}
		
		if( book.getState().equals("�ѽ�")){
			throw new Exception( "��Ǹ���Ȿ���Ѿ�����ˣ��黹��������١�");
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
