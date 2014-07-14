package ruandao.bookstore.server;

import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

import ruandao.bookstore.*;

public class BookServerThread extends Thread {
	private BookManager bookManager;
	private AccountManager accountManager;
	private Socket socket;
	
	public BookServerThread(BookManager bookManager, AccountManager accountManaer, Socket socket){
		this.bookManager = bookManager;
		this.accountManager = accountManaer;
		this.socket = socket;
	}
			
	public void run() {
		try {
			handleRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void handleRequest() throws Exception {
		
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
					
		//��ȡ�ͻ�������Ķ���
		Command command = (Command) ois.readObject();
			
		String username = command.getUserName();
		String password = command.getPassword();
		//��½
		if(Command.CMD_LOGIN.equals(command.getAction())){
			try{
				Account account = accountManager.login(username, password);
				oos.writeObject(account);
			}
			catch(Exception exc){
				oos.writeObject(exc);
			}
		}
		

		oos.flush();
		socket.shutdownOutput();
		socket.close();
		oos.close();
		ois.close();
	}
	
	public static void main( String[] args) 
			throws Exception{
		
		BookManager bookManager = new BookManager("");
		AccountManager accountManager =new AccountManager("");
		
		System.out.println("server starting...");
	   
		ServerSocket ss =new ServerSocket(8888);//����socket����
		while(true){
			Socket socket = ss.accept(); // ���տͻ�������
			new BookServerThread(bookManager, accountManager, socket).start();
		}
	
	} // end of main

}
