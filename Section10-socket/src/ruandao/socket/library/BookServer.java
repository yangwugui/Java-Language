package ruandao.socket.library;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BookServer {

	public static void main(String[] args) throws Exception {
		BookXmlManager bookManager = new BookXmlManager();
		String xmlFile = "Data Files/book.xml";
		bookManager.open(xmlFile);
		
		System.out.println("book server starting...");
	   
		ServerSocket ss = new ServerSocket(8800);//创建socket对象
		while(true){
		
			// 整个流程为反复做下述两件事情：
			// 1. 获取Request对象。
			// 2. 根据Request的action做不同的处理。
			
			// 接收客户端请求,阻塞线程。
			Socket socket = ss.accept(); 
				
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
						
			//获取客户端请求的对象
			Command command = (Command) ois.readObject();
				
			if(Command.NEW_BOOK.equals(command.getAtionName())){
				bookManager.add(command.getBook());
				bookManager.save(xmlFile);
				oos.writeObject(true);
			}
			if(Command.BORROW.equals(command.getAtionName())){
				try{
					bookManager.borrow(command.getString("person"), command.getString("bookName"));
					bookManager.save(xmlFile);
					oos.writeObject(true);
				}
				catch (Exception except){
					oos.writeObject(except);
				}
			}
			if(Command.GET_ALL.equals(command.getAtionName())){
				Book[] books = bookManager.getAllBooks();
				oos.writeObject(books);
			}
			if(Command.GIVE_BACK.equals(command.getAtionName())){
				try{
					int days = bookManager.guihuan(command.getString("person"), command.getString("bookName"));
					bookManager.save(xmlFile);
					oos.writeObject(days);
				}
				catch (Exception except){
					oos.writeObject(except);
				}
			}
			if(Command.REMOVE.equals(command.getAtionName())){
				try{
					bookManager.remove( command.getString("bookName"));
					bookManager.save(xmlFile);
					oos.writeObject(true);
				}
				catch (Exception except){
					oos.writeObject(except);
				}
			}

			oos.flush();
			socket.shutdownOutput();
		    socket.close();
		    oos.close();
			ois.close();
			ss.close();
			
		} // end of while
	
	} // end of main

}
