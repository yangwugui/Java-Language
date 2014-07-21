package ruandao.socket.tcp;

import java.io.*;
import java.net.*;

public class TcpServer  {
			
	public static void main( String[] args) 
			throws Exception{
		
		System.out.println("server starting...");
	   
		ServerSocket ss =new ServerSocket(8800);//����socket����
		while(true){
		
			// ��������Ϊ�����������������飺
			// 1. ��ȡRequest����
			// 2. ����Request��action����ͬ�Ĵ���
			
			// ���տͻ�������,�����̡߳�
			Socket socket = ss.accept(); 
				
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());			
						
			//��ȡ�ͻ�������Ķ���
			TcpRequest request = (TcpRequest) ois.readObject();
				
			//��½
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
			
			//��׳�
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
