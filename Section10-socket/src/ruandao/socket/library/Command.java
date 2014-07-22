package ruandao.socket.library;

import java.io.Serializable;
import java.util.HashMap;

public class Command implements Serializable{
	final static public String NEW_BOOK = "NewBook";
	final static public String BORROW = "Borrow";
	final static public String GET_ALL = "GetAll";
	final static public String GIVE_BACK = "GiveBack";
	final static public String REMOVE = "Remove";
	
	String actionName;
	HashMap<String, Object> parameters;

	public Command(String actionName){
		this.actionName = actionName;
		parameters = new HashMap<String,Object>();
	}
	public String getAtionName() {
		return actionName;
	}

	public void setAtionName(String ationName) {
		this.actionName = ationName;
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
