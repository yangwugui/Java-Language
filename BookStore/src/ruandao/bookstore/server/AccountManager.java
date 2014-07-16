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

		
	// ��ϣӳ����keyΪAccount��name��
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
		String error = "�˺Ż����������";
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
			throw new Exception("�û����Ѿ����ڣ��뻻һ���������ԡ�");
		}
		
		if( account.getName().length() < 6 ){
			throw new Exception("�û�����������6����ĸ��");
		}
		
		if( account.getPassword().length() < 6 ){
			throw new Exception("���볤�Ȳ�������6����ĸ��");
		}
		
		// �����ڴ��е����ݡ�
		accountMap.put(account.getName(), account);
				
		// ������д����account.xml�С�
		writeToXmlFile();
	}
	
	// �� xml�е�����ȫ���������ڴ��С�
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
	
    //�����е��˺���Ϣ���浽xml�ļ��С�
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
