package ruandao.bookstore.server;

import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ruandao.bookstore.*;

public class BookServer {
			
	public static void main( String[] args) 
			throws NumberFormatException, FileNotFoundException, IOException, 
			ParserConfigurationException, SAXException, 
			ClassNotFoundException, TransformerException, ParseException{
		
		System.out.println("server starting...");
	   
		BookManager bookManager = new BookManager("");
		AccountManager accountManager =new AccountManager("");
		
		ServerSocket ss =new ServerSocket(8888);//创建socket对象
		while(true){
		
			// 整个流程为反复做下述两件事情：
			// 1. 获取Command对象。
			// 2. 根据Command的action做不同的处理。
			
			Socket socket = ss.accept(); // 接收客户端请求
				
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
						
			//获取客户端请求的对象
			Command command = (Command) ois.readObject();
				
			String username = command.getUserName();
			String password = command.getPassword();
			//登陆
			if(Command.CMD_LOGIN.equals(command.getAction())){
				try{
					Account account = accountManager.login(username, password);
					oos.writeObject(account);
				}
				catch(Exception exc){
					oos.writeObject(exc);
				}
			}
			if(Command.CMD_ADD_BOOK.equals(command.getAction())){
				bookManager.addBook(command.getString("isbn"), command.getInt("amount") );
				bookManager.writeToXmlFile();
				oos.writeObject(true);

			}

			oos.flush();
			socket.shutdownOutput();
		    socket.close();
		    oos.close();
			ois.close();
			
		} // end of while
	
	} // end of main
	
}
