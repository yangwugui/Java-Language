package ruandao.socket.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class AccountServer {

	public static void main(String[] args) 
			throws IOException, ClassNotFoundException {
		ServerSocket ss = new ServerSocket(8800);
		
		System.out.println("server start ...");
		
		Socket s = ss.accept();  // ¼àÌý 8800£¬ ×èÈûÏß³Ì¡£

		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		
		String info = (String)ois.readObject();
		
		String reply = "Welcom, " + info;
		
		
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(reply);
		
		oos.close();
		ois.close();
		s.close();
		
		System.out.println("server stoped...");
	}

}
