package ruandao.bookstore.client;

import java.io.IOException;
import java.util.Properties;

public class ClientSettings {
	static Properties serverProperties = new Properties();
	static Properties clientProperties = new Properties();
	static {
		try {
			serverProperties.load(ClientSettings.class.getResourceAsStream("/server.ini"));
		} catch (IOException e) {
			serverProperties.setProperty("datafiles", "Data Files/");
			serverProperties.setProperty("portnumber", "9000");
		}
		try {
			clientProperties.load(ClientSettings.class.getResourceAsStream("/client.ini"));
		} catch (IOException e) {
			serverProperties.setProperty("sever", "localhost");
			serverProperties.setProperty("portnumber", "9000");
		}
	}
	
	
}
