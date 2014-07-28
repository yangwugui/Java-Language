package ruandao.bookstore;

import java.io.Serializable;
import java.util.HashMap;

import ruandao.bookstore.*;

// 值对象，表示C/S之间的消息格式。
@SuppressWarnings("serial")
public class Command implements Serializable {
	final static public String CMD_LOGIN = "Login";
	final static public String CMD_NEW_BOOK = "NewBook";
	final static public String CMD_FETCH_BOOK = "FetchBook";
	final static public String CMD_SEARCH_BOOK = "SearchBook";
	final static public String CMD_ADD_BOOK = "AddBook";
	final static public String CMD_REMOVE_BOOK = "RemoveBook";
	
	String action;
    String userName;
	String password;
    HashMap<String, Object> parameters;
	
    public Command(String action, String userName, String password){
    	this.action = action;
    	this.userName = userName;
    	this.password = password;
    	parameters = new HashMap<String, Object>();
    }

	public String getAction() {
		return this.action;
	}
	
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Book getBook() {
		return (Book) this.parameters.get("book");
	}
	public void putBook(Book book) {
		this.parameters.put("book", book);
	}
	
	public String getString(String param){
		return (String) this.parameters.get(param);
	}
	
	public void putString(String param, String value){
		this.parameters.put(param, value);
	}

	public int getInt(String param){
		return (int) this.parameters.get(param);
	}
	
	public void putInt(String param, int value){
		this.parameters.put(param, value);
	}

}
