package ruandao.xml;


import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomDemo {
	
	public static void main( String[] arg) 
			throws ParserConfigurationException, SAXException, IOException, TransformerException{
		Document doc = openDocument("src/book.xml");
		NodeList bookNodeList = doc.getElementsByTagName("book");
		for( int i=0; i<bookNodeList.getLength(); i++ ){
			Node node = bookNodeList.item(i);
			Element book = (Element)node;
			System.out.println("\nµÚ" + (i+1) + "±¾Êé");
			System.out.println("ISBN=" + book.getAttribute("isbn"));
			System.out.println("title=" + book.getAttribute("title"));
			System.out.println(book.getTextContent());
		}
		saveDocument(doc,"src\\out.xml");
	}
	
	public static Document openDocument(String filename) 
			throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db.parse( new File(filename));
	}
	
	public static Document newDocument() 
			throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db.newDocument();
	}
	
	public static void saveDocument(Document document, String filename) 
			throws TransformerException, FileNotFoundException{
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer =tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		DOMSource source=new DOMSource(document);
		StreamResult result = new StreamResult(new FileOutputStream(filename));
		
		transformer.transform(source, result);
	}
}
