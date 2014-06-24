package ruandao.oop.bookstore;

public class BookManager {
	private Book[] books;

	public BookManager( int max) {
		books = new Book[max];
	}
	
	public void init(){
		append( new Book( "Asp.net ����") );
		append( new Book("Java ����") );
		append( new Book("Struts ����") );
	}

	public int getIndex(String name){
		for(int i = 0; i<books.length; i++){
			if( name.equals( books[i].getName() ) ) return i;
		}
		return -1;
	}
	
	public String guihuan(String name) {
		int index = getIndex(name);
		if( index == -1){
			return "��Ǹ����Ҫ�����鲻���������ġ�";
		}
		
		if( books[index].getState().equals("�ѻ�")){
			return "���Ѿ������Ȿ���ˣ�:)";
		}
		books[index].setState ( "�ѻ�" );
		return "";
	}

	public String borrow( String name) {
		int index = getIndex(name);
		if( index == -1){
			return "��Ǹ��û���ҵ�������Ҫ���顣";
		}
		
		if( books[index].getState().equals("�ѽ�")){
			return "��Ǹ����Ҫ�����Ѿ��������ˣ��������������";
		}
		
		books[index].setState( "�ѽ�");
		int count = books[index].getCount();
		books[index].setCount(count + 1);
		return "";
	}

	public String remove(String name) {
		int index = getIndex(name);
		if( index == -1){
			return "��Ǹ�������û���Ȿ�顣";
		}
		
		if( books[index].getState().equals("�ѽ�")){
			return "��Ǹ���Ȿ���Ѿ�����ˣ��黹��������١�";
		}
		
		delete(index);
		return "";
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

	public String add(String name) {
		return append(new Book(name));
	}

	public String append(Book book) {
		int firstNull = -1;
		for( int i=0; i<books.length; i++){
			if( books[i] == null ){
				firstNull = i;
				break;
			}
		}
		if( firstNull == -1 ){
			return "�����Ѿ����ˣ��Ų����ˣ�";
		}
		books[firstNull] = book;
		return "";
	}

	
}
