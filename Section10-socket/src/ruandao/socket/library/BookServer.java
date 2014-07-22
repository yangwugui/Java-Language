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
	   
		ServerSocket ss = new ServerSocket(8800);//����socket����
		while(true){
		
			// ��������Ϊ�����������������飺
			// 1. ��ȡRequest����
			// 2. ����Request��action����ͬ�Ĵ���
			
			// ���տͻ�������,�����̡߳�
			Socket socket = ss.accept(); 
				
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
						
			//��ȡ�ͻ�������Ķ���
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
