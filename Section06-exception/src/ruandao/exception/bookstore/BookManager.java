package ruandao.exception.bookstore;

public class BookManager {
	private Book[] books;

	public BookManager( int max) {
		books = new Book[max];
	}
	
	public void init() throws Exception{
		append( new Book( "Asp.net 入门") );
		append( new Book("Java 入门") );
		append( new Book("Struts 入门") );
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
			throw new Exception( "抱歉，你要还的书不是在这儿借的。");
		}
		
		if( books[index].getState().equals("已还")){
			throw new Exception( "你已经还过这本书了，:)" );
		}
		books[index].setState ( "已还" );
	}

	public void borrow( String name) throws Exception {
		int index = getIndex(name);
		if( index == -1){
			throw new Exception( "抱歉，没有找到你所需要的书。");
		}
		
		if( books[index].getState().equals("已借")){
			throw new Exception( "抱歉，你要的书已经被借走了，请过几天再来。");
		}
		
		books[index].setState( "已借");
		int count = books[index].getCount();
		books[index].setCount(count + 1);
	}

	public void remove(String name) throws Exception {
		int index = getIndex(name);
		if( index == -1){
			throw new Exception( "抱歉，书库中没有这本书。");
		}
		
		if( books[index].getState().equals("已借")){
			throw new Exception( "抱歉，这本书已经借出了，归还后才能销毁。");
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
			throw new Exception(  "货架已经满了，放不下了！");
		}
		books[firstNull] = book;
	}
	
}
