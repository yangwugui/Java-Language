package ruandao.exception.bookstore;

public class BookManager {
	private Book[] books;

	public BookManager( int max) {
		books = new Book[max];
	}
	
	public void init() throws Exception{
		append( new Book( "Asp.net ����") );
		append( new Book("Java ����") );
		append( new Book("Struts ����") );
	}

	public int getIndex(String name){
		for(int i = 0; i<books.length; i++){
			if(books[i]==null) return -1;
			if( name.equals( books[i].getName() ) ) return i;
		}
		return -1;
	}
	
	public void guihuan(String name) throws Exception {
		int index = getIndex(name);
		if( index == -1){
			throw new Exception( "��Ǹ����Ҫ�����鲻���������ġ�");
		}
		
		if( books[index].getState().equals("�ѻ�")){
			throw new Exception( "���Ѿ������Ȿ���ˣ�:)" );
		}
		books[index].setState ( "�ѻ�" );
	}

	public void borrow( String name) throws Exception {
		int index = getIndex(name);
		if( index == -1){
			throw new Exception( "��Ǹ��û���ҵ�������Ҫ���顣");
		}
		
		if( books[index].getState().equals("�ѽ�")){
			throw new Exception( "��Ǹ����Ҫ�����Ѿ��������ˣ��������������");
		}
		
		books[index].setState( "�ѽ�");
		int count = books[index].getCount();
		books[index].setCount(count + 1);
	}

	public void remove(String name) throws Exception {
		int index = getIndex(name);
		if( index == -1){
			throw new Exception( "��Ǹ�������û���Ȿ�顣");
		}
		
		if( books[index].getState().equals("�ѽ�")){
			throw new Exception( "��Ǹ���Ȿ���Ѿ�����ˣ��黹��������١�");
		}
		
		delete(index);
	}

	public void delete(int index) {
		for( int i = index; i<books.length-1; i++){
			books[index] = books[index+1];
			if(books[index+1]==null) break;
		}
		books[books.length-1] = null;
	}

	public String list() {
		String displayString = "";
		for(int i=0; i<books.length; i++){
			if(books[i]==null) break;
			displayString += (i+1) + ". " + books[i] ;
		}
		return displayString;
	}

	public void add(String name) throws Exception {
		append(new Book(name));
	}

	public void append(Book book) throws Exception {
		int firstNull = -1;
		for( int i=0; i<books.length; i++){
			if( books[i] == null ){
				firstNull = i;
				break;
			}
		}
		if( firstNull == -1 ){
			throw new Exception(  "�����Ѿ����ˣ��Ų����ˣ�");
		}
		books[firstNull] = book;
	}
	
}
