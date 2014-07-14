package ruandao.bookstore;

import java.io.*;
import java.text.*;
import java.util.*;

import org.w3c.dom.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

import ruandao.utility.*;

public class BookManager {

	// ��ϣӳ����keyΪͼ���ISBN��
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
		
		// �� xml�е�����ȫ���������ڴ��С�
		readFormXmlFile();
	}

	public Book fetchBook(String isbn) {   
		return allBooks.get(isbn);
	}
	
	public Book[] getAllBooks(){
		return searchBooks(null,null);
	}
	
	public Book[] getBooksByType(String type){
		return searchBooks(type,null);
	}
	
	public Book[] searchBooks(String search){
		return searchBooks(null,search);
	}
	
	// typeΪnull���� ""����ʾ�����������͵�ͼ�顣
	// search��ʾ�������ߡ����⡢�������ƥ��������
	public Book[] searchBooks(String type, String search ){
		if( "".equals(type) ) type = null;
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
	
	// ����һ��ͼ�飬������������Ѿ�����ͬ�����ļ��򷵻�ʧ�ܡ����ӵĲ��������Ĺ��������㣺
	// 1. ����ͼ�����Ϣ���ӵ�allBooks�С�
	// 2. ��allBooks�е����ݱ��浽book.xml�ļ��С�
	public boolean addBook(Book book, String content) throws 
			TransformerFactoryConfigurationError, TransformerException, 
			IOException, ParserConfigurationException, SAXException {
		if( allBooks.containsKey(book.getISBN())) return false;
		
		allBooks.put(book.getISBN(), book);
		
		// ������д����book.xml�С�
		writeToXmlFile();
		
		return true;
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
			book.setType(Type.valueOf(novelElement.getAttribute("type")));
		
			allBooks.put(book.getISBN(), book);
		}
	}

    //�����е�ͼ����Ϣ���浽xml�ļ��С�
	private void writeToXmlFile()
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
			
			root.appendChild(bookNode);		
		}
		
		Xml.saveDocument(doc, this.getBookXmlFile());
	}
	
}
