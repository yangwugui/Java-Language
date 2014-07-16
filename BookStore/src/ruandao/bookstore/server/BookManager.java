package ruandao.bookstore.server;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ruandao.bookstore.Book;
import ruandao.bookstore.Type;
import ruandao.utility.*;

public class BookManager {
	
	static private BookManager instance = null;
	
	public static BookManager getInstance() throws 
		ParserConfigurationException, SAXException, IOException, ParseException{
		if( instance == null ) instance = new BookManager();
		return instance;
	}

	// ��ϣӳ����keyΪͼ���ISBN��
	HashMap<String,Book> allBooks;
	
	String getBookXmlFile() {
		String dataFolder = ServerSettings.getDataFolder();
	
		if ( !dataFolder.endsWith("/") && !dataFolder.endsWith("\\")){
			dataFolder += "/";
		}
		return dataFolder + "book.xml";
	}

	private BookManager() throws 
			ParserConfigurationException, SAXException, IOException, ParseException {
		allBooks = new HashMap<String,Book>();
		// �� xml�е�����ȫ���������ڴ��С�
		readFromXmlFile();
	}

	public Book fetchBook(String isbn) {   
		return allBooks.get(isbn);
	}
	
	public Book[] getAllBooks(){
		return searchBooks(null,null);
	}
	
	public Book[] getBooksByType(Type type){
		return searchBooks(type,null);
	}
	
	public Book[] searchBooks(String search){
		return searchBooks(null,search);
	}
	
	// typeΪnull���� ""����ʾ�����������͵�ͼ�顣
	// search��ʾ�������ߡ����⡢�������ƥ��������
	public Book[] searchBooks(Type type, String search ){
		if( "".equals(search) ) search = null;
		ArrayList<Book> books = new ArrayList<Book>();
		for(Book book : this.allBooks.values()){
			if( type!=null && ! book.getType().name().equals(type)){
				continue;
			}
			if( search==null ){
				books.add(book);
				continue;
			}
			if( book.getAuthor().indexOf(search) != -1 ){
				books.add(book);
				continue;
			}
			if( book.getTitle().indexOf(search) != -1 ){
				books.add(book);
				continue;
			}
			if( book.getPublisher().indexOf(search) != -1 ){
				books.add(book);
				continue;
			}
		}
		
		return books.toArray(new Book[0]);
 	}
	
	// �����µ�ͼ�顣ʹ��ʱӦȷ������ָ����isbn���µģ����򽫸����������ݡ�
	public void newBook(Book book) {
		allBooks.put(book.getISBN(), book);
	}
	
	// ���ͼ�飬����������ͼ��Ŀ�档
	// ʹ��ʱӦ�ñ�֤isbn�Ǵ��ڵģ�������������ʱ��ָ���쳣��
	public void addBook(String isbn, int amount) {
		Book book = fetchBook(isbn);
		book.setAmount( book.getAmount() + amount );
	}
	
	// �Ƴ�ͼ�飬����������ͼ��Ŀ�档
	// ʹ��ʱӦ�ñ�֤isbn�Ǵ��ڵģ�������������ʱ��ָ���쳣��
	public void removeBook(String isbn, int amount) {
		Book book = fetchBook(isbn);
		book.setAmount( book.getAmount() - amount );
	}
	
	private void readFromXmlFile() throws 
			ParserConfigurationException, SAXException, IOException {
		Document doc = Xml.getDocument(getBookXmlFile());
		NodeList bookNodes = doc.getElementsByTagName("book");
		for(int i=0; i<bookNodes.getLength(); i++){
			Element novelElement = (Element)bookNodes.item(i);
			Book book = new Book();
			
			book.setAuthor(novelElement.getAttribute("author"));
			book.setCoverImage(novelElement.getAttribute("coverImage"));
			book.setISBN(novelElement.getAttribute("ISBN"));
			book.setPublisher(novelElement.getAttribute("publisher"));
			book.setTitle(novelElement.getAttribute("title"));
			book.setType(Type.valueOf(novelElement.getAttribute("type")));
			book.setPrice(new BigDecimal( novelElement.getAttribute("price") ) );
			book.setAmount(Integer.parseInt(novelElement.getAttribute("amount")) );
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				book.setReleaseDate(df.parse(novelElement.getAttribute("releaseDate")));
			} catch (ParseException e) {
				book.setReleaseDate(null);
			}
			book.setIntroduction(novelElement.getTextContent());
			allBooks.put(book.getISBN(), book);
		}
	}

    //�����е�ͼ����Ϣ���浽xml�ļ��С�
	public void writeToXmlFile()
			throws TransformerFactoryConfigurationError, TransformerException, 
			IOException, ParserConfigurationException, SAXException {
		Document doc = Xml.newDocument(); 
		Element root = doc.createElement("books");
		doc.appendChild(root);
		for( Book book : allBooks.values()){
			Element bookNode = doc.createElement("book");
			bookNode.setAttribute("author", book.getAuthor());
			bookNode.setAttribute("coverImage", book.getCoverImage());
			bookNode.setAttribute("ISBN", book.getISBN());
			bookNode.setAttribute("publisher", book.getPublisher());
			bookNode.setAttribute("title", book.getTitle());
			bookNode.setAttribute("type", book.getType().name());
			bookNode.setAttribute("price", "" + book.getPrice());
			bookNode.setAttribute("amount", "" + book.getAmount());
			bookNode.setTextContent(book.getIntroduction());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			bookNode.setAttribute("releaseDate", df.format(book.getReleaseDate()));
			
			root.appendChild(bookNode);		
		}
		
		Xml.saveDocument(doc, this.getBookXmlFile());
	}
	
}
