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

public class BookXmlManager extends BookManager {
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
