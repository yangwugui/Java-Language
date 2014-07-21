package ruandao.socket.tcp;

import java.io.*;
import java.net.*;

public class TcpServer  {
			
	public static void main( String[] args) 
			throws Exception{
		
		System.out.println("server starting...");
	   
		ServerSocket ss =new ServerSocket(8800);//创建socket对象
		while(true){
		
			// 整个流程为反复做下述两件事情：
			// 1. 获取Request对象。
			// 2. 根据Request的action做不同的处理。
			
			// 接收客户端请求,阻塞线程。
			Socket socket = ss.accept(); 
				
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
						
			//获取客户端请求的对象
			TcpRequest request = (TcpRequest) ois.readObject();
				
			//登陆
			if("Login".equals(request.getAction())){
				Object[] parameter = request.getParameter();
				String name = parameter[0].toString();
				String password = parameter[1].toString();
				Boolean result = false;
				if(name.equals("Test") && password.equals("Ruandao")) {
					result = true ;
				}
				
				oos.writeObject(result);
			}
			
			//求阶乘
			if("Factorial".equals(request.getAction())){
				Object[] parameter = request.getParameter();
				int x = Integer.parseInt( parameter[0].toString() );

				int result = 1;
				for( int i = 1; i<=x; i++){
					result *= i;
				}

				oos.writeObject(result);
			}
				
			oos.flush();
			socket.shutdownOutput();
		    socket.close();
		    oos.close();
			ois.close();
			
		} // end of while
	
	} // end of main

}
