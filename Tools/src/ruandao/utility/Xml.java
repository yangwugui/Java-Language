package ruandao.utility;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Xml {
	public static Document getDocument(String filename) 
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
