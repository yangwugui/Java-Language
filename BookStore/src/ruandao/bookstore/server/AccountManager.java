package ruandao.bookstore.server;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ruandao.bookstore.Account;
import ruandao.bookstore.Book;
import ruandao.utility.Xml;

public class AccountManager {

	
	static private AccountManager instance = null;
	
	public static AccountManager getInstance() throws 
		ParserConfigurationException, SAXException, IOException, ParseException{
		if( instance == null ) instance = new AccountManager();
		return instance;
	}

		
	// 哈希映射表的key为Account的name。
	HashMap<String,Account> accountMap;
	
	private String getAccountXmlFile() {
		String dataFolder = ServerSettings.getDataFolder();
		if ( !dataFolder.endsWith("/") && !dataFolder.endsWith("\\")){
			dataFolder += "/";
		}
		return dataFolder + "account.xml";
	}

	public AccountManager() 
			throws ParserConfigurationException, SAXException, IOException, ParseException {
		accountMap = new HashMap<String, Account>();
		
		readFromXml();
	}

	public Account login(String name, String password) 
			throws Exception {   
		String error = "账号或者密码出错！";
		if( password==null || !accountMap.containsKey(name)){
			throw new Exception(error);
		}
		
		Account account = accountMap.get(name);
		if( !password.equals(account.getPassword()) ){
			throw new Exception(error);
		}
		return account;	
	}
	
	public void register(Account account) 
			throws TransformerFactoryConfigurationError, Exception {
		if( this.accountMap.containsKey(account.getName()) ){
			throw new Exception("用户名已经存在，请换一个名字试试。");
		}
		
		if( account.getName().length() < 6 ){
			throw new Exception("用户名不能少于6个字母。");
		}
		
		if( account.getPassword().length() < 6 ){
			throw new Exception("密码长度不能少于6个字母。");
		}
		
		// 更新内存中的数据。
		accountMap.put(account.getName(), account);
				
		// 把数据写出到account.xml中。
		writeToXmlFile();
	}
	
	// 把 xml中的内容全部读出到内存中。
	private void readFromXml() throws ParserConfigurationException,
			SAXException, IOException {
		Document doc = Xml.getDocument(getAccountXmlFile());
		NodeList accountNodes = doc.getElementsByTagName("account");
		for(int i=0; i<accountNodes.getLength(); i++){
			Element novelElement = (Element)accountNodes.item(i);
			Account account = new Account();
			
			account.setAddress(novelElement.getAttribute("address"));
			account.setAlias(novelElement.getAttribute("alias"));
			account.setEmail(novelElement.getAttribute("email"));
			account.setIsAdmin(Boolean.parseBoolean(novelElement.getAttribute("isAdmin")));
			account.setName(novelElement.getAttribute("name"));
			account.setPassword(novelElement.getAttribute("password"));
			account.setPhone(novelElement.getAttribute("phone"));
		
			accountMap.put(account.getName(), account);
		}
	}
	
    //把所有的账号信息保存到xml文件中。
	private void writeToXmlFile()
			throws TransformerFactoryConfigurationError, TransformerException, 
			IOException, ParserConfigurationException, SAXException {
		Document doc = Xml.newDocument(); 
		Element root = doc.createElement("accounts");
		doc.appendChild(root);
		for( Account account : accountMap.values()){
			Element bookNode = doc.createElement("account");
			bookNode.setAttribute("address", account.getAddress());
			bookNode.setAttribute("alias", account.getAlias());
			bookNode.setAttribute("email", account.getEmail());
			bookNode.setAttribute("isAdmin", ""+account.getIsAdmin());
			bookNode.setAttribute("name", account.getName());
			bookNode.setAttribute("password", account.getPassword());
			bookNode.setAttribute("phone", account.getPhone());
		}
		
		Xml.saveDocument(doc, this.getAccountXmlFile());
	}

}
