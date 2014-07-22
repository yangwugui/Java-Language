package ruandao.socket.library;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BookClient {
	private Object execute(Command command) 
			throws Exception{
		Socket socket = new Socket("localhost",8800);
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

	public int guihuan(String person, String bookName) throws Exception {
		Command command = new Command(Command.GIVE_BACK);
		command.putString("person", person);
		command.putString("bookName", bookName);
		Object response = execute(command);
		if( response instanceof Exception ){
			throw (Exception)response;
		}
		return (int) response;
	}
	public void borrow(String person, String bookName) throws Exception {
		Command command = new Command(Command.BORROW);
		command.putString("person", person);
		command.putString("bookName", bookName);
		Object response = execute(command);
		if( response instanceof Exception ){
			throw (Exception)response;
		}
	}
	public void remove(String name) throws Exception {
		Command command = new Command(Command.REMOVE);
		command.putString("bookName", name);
		Object response = execute(command);
		if( response instanceof Exception ){
			throw (Exception)response;
		}
	
	}
	public void add(Book book) 
			throws Exception{
		Command command = new Command(Command.NEW_BOOK);
		command.putBook(book);
		execute(command);
	}
	public Book[] getAllBooks() throws Exception {
		Command command = new Command(Command.GET_ALL);
		return (Book[])execute(command);
	}
}
