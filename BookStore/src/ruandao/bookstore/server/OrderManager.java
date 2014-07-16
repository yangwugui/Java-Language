package ruandao.bookstore.server;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ruandao.bookstore.Book;
import ruandao.bookstore.Order;
import ruandao.bookstore.OrderDetail;
import ruandao.utility.Xml;

public class OrderManager {
	
	static private OrderManager instance = null;
	
	public static OrderManager getInstance() throws 
		ParserConfigurationException, SAXException, IOException, ParseException{
		if( instance == null ) instance = new OrderManager();
		return instance;
	}
		
	// key值为订单编号
	HashMap<String,Order> allOrders;
	
	String getOrderXmlFile() throws ParserConfigurationException, SAXException, IOException, ParseException {
		String dataFolder = ServerSettings.getDataFolder();
	
		if ( !dataFolder.endsWith("/") && !dataFolder.endsWith("\\")){
			dataFolder += "/";
		}
		return dataFolder + "order.xml";
	}

	public OrderManager() throws 
		ParserConfigurationException, SAXException, IOException, ParseException{
		allOrders = new HashMap<String,Order>();
		readFromXmlFile();
	}
	
	public void select(Order order, Book book){
		OrderDetail detail = order.getDetails().get(book.getISBN());
		if( detail == null ){
			detail = new OrderDetail();
			detail.setIsbn(book.getISBN());
			detail.setQuantity(0);
			detail.setUnitPrice(book.getPrice());
			order.getDetails().put(book.getISBN(), detail);
		}
		int amount = detail.getQuantity() + 1;
		detail.setQuantity(amount);
	}
	
	public void setAmount(Order order, Book book, int amount){
		if( amount <=0 ){
			order.getDetails().remove(book.getISBN());
		}
		OrderDetail detail = order.getDetails().get(book.getISBN());
		if( detail == null ){
			detail = new OrderDetail();
			detail.setIsbn(book.getISBN());
			detail.setQuantity(0);
			detail.setUnitPrice(book.getPrice());
			order.getDetails().put(book.getISBN(), detail);
		}
		detail.setQuantity(amount);
	}
	
	public boolean isExistOrder(String code){
		Order order = allOrders.get(code);
		return order == null ? false : true;
	}
	
	// 自动生成订单号。
	public Order createOrder(String account){
		Order order = new Order();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");
		order.setCode(sdf.format(new Date()));
		return order;
	}
	
	public void confirmOrder(Order order){
		allOrders.put(order.getCode(), order);
	}
	
	private void readFromXmlFile() throws 
			ParserConfigurationException, SAXException, IOException, ParseException {
		Document doc = Xml.getDocument(getOrderXmlFile());
		NodeList bookNodes = doc.getElementsByTagName("book");
		for(int i=0; i<bookNodes.getLength(); i++){
			Element novelElement = (Element)bookNodes.item(i);
			Order order = new Order();
			
/*			order.setAuthor(novelElement.getAttribute("author"));
			order.setCoverImage(novelElement.getAttribute("coverImage"));
			order.setISBN(novelElement.getAttribute("ISBN"));
			order.setPublisher(novelElement.getAttribute("publisher"));
			order.setTitle(novelElement.getAttribute("title"));
			order.setType(Type.valueOf(novelElement.getAttribute("type")));
			order.setPrice(new BigDecimal( novelElement.getAttribute("price") ) );
			order.setAmount(Integer.parseInt(novelElement.getAttribute("amount")) );
*/			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				order.setOrderDate(df.parse(novelElement.getAttribute("orderDate")));
			} catch (ParseException e) {
				order.setOrderDate(null);
			}

			allOrders.put(order.getCode(), order);
		}
	}

    //把所有的图书信息保存到xml文件中。
	public void writeToXmlFile()
			throws TransformerFactoryConfigurationError, TransformerException, 
			IOException, ParserConfigurationException, SAXException, ParseException {
		Document doc = Xml.newDocument(); 
		Element root = doc.createElement("books");
		doc.appendChild(root);
		for( Order order : allOrders.values()){
			Element orderNode = doc.createElement("book");
/*			orderNode.setAttribute("author", order.getAuthor());
			orderNode.setAttribute("coverImage", order.getCoverImage());
			orderNode.setAttribute("ISBN", order.getISBN());
			orderNode.setAttribute("publisher", order.getPublisher());
			orderNode.setAttribute("title", order.getTitle());
			orderNode.setAttribute("type", order.getType().name());
			orderNode.setAttribute("price", "" + order.getPrice());
			orderNode.setAttribute("amount", "" + order.getAmount());
			orderNode.setTextContent(order.getIntroduction());
*/			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			orderNode.setAttribute("orderDate", df.format(order.getOrderDate()));
			
			root.appendChild(orderNode);		
		}
		
		Xml.saveDocument(doc, this.getOrderXmlFile());
	}

}
