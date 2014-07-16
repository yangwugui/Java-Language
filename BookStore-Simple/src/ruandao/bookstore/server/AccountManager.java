package ruandao.bookstore.server;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ruandao.bookstore.Account;
import ruandao.utility.Xml;

public class AccountManager {

	// 哈希映射表的key为Account的name。
	HashMap<String,Account> accountMap;
	
	private String dataFolder;

	private String getAccountXmlFile() {
		if ( !dataFolder.endsWith("/") && !dataFolder.endsWith("\\")){
			dataFolder += "/";
		}
		return dataFolder + "account.xml";
	}

	public AccountManager(String dataFolder) 
			throws ParserConfigurationException, SAXException, IOException, ParseException {
		this.dataFolder = dataFolder;
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
}
