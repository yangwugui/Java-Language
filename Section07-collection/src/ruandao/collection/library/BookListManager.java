package ruandao.collection.library;

import java.util.ArrayList;

public class BookListManager implements BookManager {
	private ArrayList<Book> books;

	public BookListManager() {
		books = new ArrayList<Book>();
		init();
	}
	
	private void init(){
		add( new Book( "Asp.net ����") );
		add( new Book("Java ����") );
		add( new Book("Struts ����") );
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
			throw new Exception( "��Ǹ����Ҫ�����鲻���������ġ�");
		}
		
		if( book.getState().equals("�ѻ�")){
			throw new Exception( "���Ѿ������Ȿ���ˣ�:)" );
		}
		book.setState ( "�ѻ�" );
	}

	public void borrow( String name) throws Exception {
		Book book = getBook(name);
		if( book == null ){
			throw new Exception( "��Ǹ��û���ҵ�������Ҫ���顣");
		}

		if( book.getState().equals("�ѽ�")){
			throw new Exception( "��Ǹ����Ҫ�����Ѿ��������ˣ��������������");
		}
		
		book.setState( "�ѽ�");
		int count = book.getCount();
		book.setCount(count + 1);
	}

	public void remove(String name) throws Exception {
		Book book = getBook(name);
		if( book==null ){
			throw new Exception( "��Ǹ�������û���Ȿ�顣");
		}

		if( book.getState().equals("�ѽ�")){
			throw new Exception( "��Ǹ���Ȿ���Ѿ�����ˣ��黹��������١�");
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
