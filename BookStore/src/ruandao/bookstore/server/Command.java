package ruandao.bookstore.server;

import java.io.Serializable;

import ruandao.bookstore.*;

// 值对象，表示C/S之间的消息格式。
@SuppressWarnings("serial")
public class Command implements Serializable {
	
	String action;
    String userName;
    String password;
    Book book;

	

	public String getAction() {
		return this.action;
	}
	public void setAction(String action) {
		this.action = action;
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
		return this.book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public static String CMD_LOGIN	= "LOGIN";
	public static String CMD_REGISTER	= "REGISTER";
	public static String CMD_SHOW_BOOK_LIST = "SHOW_BOOK_LIST";
	public static String CMD_SHOW_TYPE_LIST = "SHOW_TYPE_LIST";
	public static String CMD_UPLOAD	= "UPLOAD";
	public static String CMD_READING = "READING";
}
