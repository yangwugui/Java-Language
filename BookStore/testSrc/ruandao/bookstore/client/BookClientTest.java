package ruandao.bookstore.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

import ruandao.bookstore.Account;

public class BookClientTest {

	public static void main(String[] args) throws UnknownHostException, FileNotFoundException, IOException, ClassNotFoundException {
		loginTest();

	}
	
	public static void loginTest() throws UnknownHostException, FileNotFoundException, IOException, ClassNotFoundException{
		BookClient bc = new BookClient();
		try{
			Account result = bc.login("admin", "aaaaa");
			System.out.println("login Test OK!");
		}
		catch( Exception exc){
			System.out.println(exc.getMessage());
		}
	}

}
