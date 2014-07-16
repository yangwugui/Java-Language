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
import ruandao.utility.*;

public class BookManager {

	// 哈希映射表的key为图书的ISBN。
	HashMap<String,Book> allBooks;
	
	private String dataFolder;

	String getBookXmlFile() {
		if ( !dataFolder.endsWith("/") && !dataFolder.endsWith("\\")){
			dataFolder += "/";
		}
		return dataFolder + "book.xml";
	}

	public BookManager(String bookFolder) throws 
			ParserConfigurationException, SAXException, IOException, ParseException {
		this.dataFolder = bookFolder;
		allBooks = new HashMap<String,Book>();
		
		// 把 xml中的内容全部读出到内存中。
		readFormXmlFile();
	}

	public Book fetchBook(String isbn) {   
		return allBooks.get(isbn);
	}
	
	public Book[] getAllBooks(){
		return allBooks.values().toArray(new Book[0]);
	}
	
	// search表示根据作者、标题、出版社的匹配条件。
	public Book[] searchBooks(String search ){
		ArrayList<Book> books = new ArrayList<Book>();
		for(Book book : this.allBooks.values()){
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
	
	// 增加新的图书。使用时应确保参数指明的isbn是新的，否则将覆盖已有数据。
	public void newBook(Book book) {
		allBooks.put(book.getISBN(), book);
	}
	
	// 添加图书，即增加已有图书的库存。
	// 使用时应该保证isbn是存在的，否则将引发运行时空指针异常。
	public void addBook(String isbn, int amount) {
		Book book = fetchBook(isbn);
		book.setAmount( book.getAmount() + amount );
	}
	
	// 移除图书，即减少已有图书的库存。
	// 使用时应该保证isbn是存在的，否则将引发运行时空指针异常。
	public void removeBook(String isbn, int amount) {
		Book book = fetchBook(isbn);
		book.setAmount( book.getAmount() - amount );
	}
	
	private void readFormXmlFile() throws 
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

    //把所有的图书信息保存到xml文件中。
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
