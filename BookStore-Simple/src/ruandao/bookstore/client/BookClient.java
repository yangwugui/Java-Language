package ruandao.bookstore.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import ruandao.bookstore.*;
import ruandao.bookstore.server.*;

public class BookClient {

	private Object doCommand(Command command) 
			throws UnknownHostException, FileNotFoundException, IOException, ClassNotFoundException{
		Socket socket = new Socket("localhost", 8888);
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		
		try{
			oos.writeObject(command);
			socket.shutdownOutput();
			return ois.readObject();
		}finally{
			ois.close();
			oos.close();
			socket.close();
		}
	}

	//µÇÂ½·½·¨
	public Account login(String name, String password) throws 
			Exception {
		Command command = new Command();
		command.setUserName(name);
		command.setPassword(password);
		command.setAction(Command.CMD_LOGIN);
		Object response = doCommand(command);
		if( response instanceof Exception ){
			throw (Exception)response;
		}
		return (Account) response;
	}

}
