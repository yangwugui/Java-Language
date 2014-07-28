package ruandao.socket.tcp;

import java.io.*;
import java.net.Socket;
	public class TcpClient{
	private Object doRequest(TcpRequest request) 
			throws Exception{
		Socket socket = new Socket("localhost",8800);
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		
		try{
			oos.writeObject(request);
			socket.shutdownOutput();
			return ois.readObject();
		}finally{
			ois.close();
			oos.close();
			socket.close();
		}
	}

	//登陆方法
	public boolean login(String name,String password) 
			throws Exception{
		TcpRequest request = new TcpRequest();
		request.setAction("Login");
		request.setParameters(new String[]{name,password});
		return (Boolean)doRequest(request);
	}
	//阶乘方法
	public int factorial(int x) 
			throws Exception, ClassNotFoundException{
		TcpRequest request = new TcpRequest();
		request.setAction("Factorial");
		request.setParameters(new Integer[]{x});

		return (Integer)doRequest(request);
	}
}