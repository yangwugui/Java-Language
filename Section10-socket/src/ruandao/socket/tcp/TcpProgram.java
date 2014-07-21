package ruandao.socket.tcp;

public class TcpProgram {

	public static void main(String[] args) 
			throws ClassNotFoundException, Exception {
		TcpClient client = new TcpClient();
		int x = 5;
		System.out.println(client.login("Test", "Ruandao"));
		System.out.println(client.factorial(x));
	}

}
