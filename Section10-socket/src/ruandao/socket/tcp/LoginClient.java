package ruandao.socket.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient {

	public static void main(String[] args) 
			throws UnknownHostException, IOException, ClassNotFoundException {
		Socket s = new Socket("localhost", 8800);
		
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		
		System.out.println("start request ....");
		
		oos.writeObject("Coolman");
		
		//s.shutdownOutput();  
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		
		String reply = (String)ois.readObject();
		
		System.out.println("服务端的响应是：" + reply);
		
		
		ois.close();
		oos.close();
		s.close();
		
	}

}
