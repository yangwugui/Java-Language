package ruandao.socket.library;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ruandao.utility.Xml;

public class BookXmlManager {

	protected HashMap<String,Book> books;
	
	public BookXmlManager() {
		books = new HashMap<String,Book>();
	}
	
	public int guihuan(String person, String bookName) throws Exception {
		Book book = books.get(bookName);
		if( book == null || !book.getBorrows().containsKey(person)){
			throw new Exception( "抱歉，你要还的书不是在这儿借的。");
		}
		
		Date now = new Date();
		int days = (int) ((now.getTime() - book.getBorrows().get(person).getStart().getTime()) / (24 * 60 * 60 * 1000));
		
		book.getBorrows().remove(person);
		book.setAmount(book.getAmount()+1);

		return days;
	}

	public void borrow(String person, String bookName) throws Exception {
		Book book = books.get(bookName);
		if( book == null){
			throw new Exception( "抱歉，没有找到你所需要的书。");
		}
		
		if( book.getAmount()==0){
			throw new Exception( "抱歉，你要的书已经被借走了，请过几天再来。");
		}
		int amount = book.getAmount();
		book.setAmount(amount-1);
		int count = book.getCount();
		book.setCount(count + 1);
		book.getBorrows().put(person, new Borrow(person));
	}

	public void remove(String name) throws Exception {
		Book book = books.get(name);
		if( book==null){
			throw new Exception( "抱歉，书库中没有这本书。");
		}
		
		if( book.getAmount()==0){
			throw new Exception( "抱歉，这本书已经全部借出了，归还后才能销毁。");
		}
		
		book.setAmount(book.getAmount()-1);
		
		// 如果同一本的数量为0，那么就删除这本书。
		if( book.getAmount()==0 && book.getBorrows().size()==0 ){
			books.remove(name);
		}
	}

	public void add(Book book) {
		books.put(book.getName(), book);
	}

	public Book[] getAllBooks() {
		return this.books.values().toArray(new Book[0]);
	}

	public void save(String filename)
			throws TransformerFactoryConfigurationError, TransformerException, 
			IOException, ParserConfigurationException, SAXException {
		Document doc = Xml.newDocument(); 
		Element root = doc.createElement("books");
		doc.appendChild(root);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for( Book book : books.values()){
			Element bookNode = doc.createElement("book");
			bookNode.setAttribute("name", book.getName());
			bookNode.setAttribute("amount", "" + book.getAmount());
			bookNode.setAttribute("count", "" + book.getCount());
			
			for( Borrow borrow : book.getBorrows().values() ){
				Element borrowNode = doc.createElement("borrow");
				borrowNode.setAttribute("person", borrow.getPerson());
				borrowNode.setAttribute("start", df.format(borrow.getStart()));
				bookNode.appendChild(borrowNode);
			}
			root.appendChild(bookNode);		
		}
		Xml.saveDocument(doc, "Data Files/book.xml");
	}
	
	public void open(String filename) throws 
		ParserConfigurationException, SAXException, IOException, ParseException {
		Document doc = Xml.getDocument("Data Files/book.xml");
		NodeList bookNodes = doc.getElementsByTagName("book");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<bookNodes.getLength(); i++){
			Element bookElement = (Element)bookNodes.item(i);
			Book book = new Book();
			
			book.setName(bookElement.getAttribute("name"));
			book.setAmount(Integer.parseInt(bookElement.getAttribute("amount")) );
			book.setCount(Integer.parseInt(bookElement.getAttribute("count")));
			
			NodeList borrowNodes = bookElement.getChildNodes();
			for( int j=0; j < borrowNodes.getLength(); j++ ){
				if( !borrowNodes.item(j).getNodeName().equals("boroow")) continue;
				Element borrowElement = (Element) borrowNodes.item(j);
				String person = borrowElement.getAttribute("person");
				Date start = df.parse(borrowElement.getAttribute("start") );
				book.getBorrows().put(person, new Borrow(person,start));
			}
			books.put(book.getName(), book);
		}
	} // method

}
