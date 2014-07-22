package ruandao.bookstore.server;

import java.io.Serializable;
import java.util.HashMap;

import ruandao.bookstore.*;

// 值对象，表示C/S之间的消息格式。
@SuppressWarnings("serial")
public class Command implements Serializable {
	final static public String CMD_LOGIN	= "LOGIN";
	
	
	String action;
    String userName;
    String password;

	HashMap<String, Object> parameters;

	public Command(String action){
		this.action = action;
		parameters = new HashMap<String,Object>();
	}
	
	public String getAction() {
		return this.action;
	}

	public String getUserName() {
		return this.userName;
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
		return (Book)parameters.get("book");
	}

	public void putBook(Book book) {
		parameters.put("book", book);
	}
	
	public String getString(String param){
		return (String)parameters.get(param);
	}
	
	public void putString(String param, String value){
		parameters.put(param, value);
	}
	
}
