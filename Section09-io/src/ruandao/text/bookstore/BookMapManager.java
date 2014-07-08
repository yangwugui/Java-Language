package ruandao.text.bookstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookMapManager implements BookManager {
	private HashMap<String,Book> books;
	private HashMap<String,Book> persons;
	
	public BookMapManager( int max) {
		books = new HashMap<String,Book>();
		persons = new HashMap<String,Book>();
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#init()
	 */
	@Override
	public void init() throws Exception{
//		add( new Book( "Asp.net ����") );
//		add( new Book("Java ����") );
//		add( new Book("Struts ����") );
	}
	
	/* (non-Javadoc)
	 * @see ruandao.collection.bookstore.BookManager#guihuan(java.lang.String)
	 */
	@Override
	public int guihuan(String person) throws Exception {
		
		Book book = persons.get(person);
		if( book == null ){
			throw new Exception( "��Ǹ����Ҫ�����鲻���������ġ�");
		}
		
		Date now = new Date();
		int days = (int) ((now.getTime() - book.borrows.get(person).getStart().getTime()) / (24 * 60 * 60 * 1000));
		
		book.borrows.remove(person);
		persons.remove(person);
		book.setAmount(book.getAmount()+1);
		
		return days;
	}

	@Override
	public void borrow(String person, String bookName) throws Exception {
		if( persons.containsKey(person)){
			throw new Exception( "��Ǹ�����ϴν���黹û�л������Ȼ���֮���ٽ衣");
		}
		
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
		book.borrows.put(person, new Borrow(person,book));
		persons.put(person, book);
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
		
		if( book.getAmount()==0){
			throw new Exception( "��Ǹ���Ȿ���Ѿ�ȫ������ˣ��黹��������١�");
		}
		
		book.setAmount(book.getAmount()-1);
		
		// ���ͬһ��������Ϊ0����ô��ɾ���Ȿ�顣
		if( book.getAmount()==0 && book.borrows.size()==0 ){
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try(BufferedWriter bw = new BufferedWriter
				( new FileWriter(filename) ) ){
			for(Book book : books.values()){
				bw.write("[Book]\n");
				bw.write("name=" + book.getName() + "\n");
				bw.write("amount=" + book.getAmount() + "\n");
				bw.write("count=" + book.getCount() + "\n");
				for(Borrow borrow : book.borrows.values()){
					bw.write("borrow=" + sdf.format(borrow.getStart()) + "," + borrow.getPerson() + "\n");
				}
			}
		}
		
	}
	
	public void open(String filename) 
			throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try( BufferedReader br = new BufferedReader(
				new FileReader(filename) )){
			String line = br.readLine();  // ""  ���� "\n"
			boolean isParsing = false;
			Book book = null;
			while(line!=null){
				
				if(line.startsWith("[Book]")){
					if( isParsing ){
						books.put(book.getName(), book);
					}
					isParsing = true;
					book = new Book();
				} // if start book
				
				if(isParsing){
					if(line.startsWith("name=")){
						book.setName(line.substring(5));
					}
					if(line.startsWith("amount=")){
						book.setAmount(Integer.parseInt(line.substring(7)) );
					}
					if(line.startsWith("count=")){
						book.setCount(Integer.parseInt(line.substring(6)) );
					}
					if(line.startsWith("borrow=")){
						String s = line.substring(7);
						String person = s.substring(11);
						Borrow b = new Borrow (person,book);
						Date start = sdf.parse(s.substring(0,11));
						b.setStart(start);
						book.borrows.put(person, b);
						persons.put(person, book);
					}
				} // if(isParsing)
				line = br.readLine();
			} // end while
			if(isParsing){
				books.put(book.getName(), book);
			}
			
		}
		
	}
	
}
