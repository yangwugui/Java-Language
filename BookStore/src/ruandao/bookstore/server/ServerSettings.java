package ruandao.bookstore.server;

import java.io.IOException;
import java.util.Properties;

public class ServerSettings {
	static Properties properties = new Properties();
	static {
		try {
			properties.load(ServerSettings.class.getResourceAsStream("/server.ini"));
		} catch (IOException e) {
			properties.setProperty("datafiles", "Data Files/");
			properties.setProperty("portnumber", "9000");
		}
	}
	
	public static String getDataFolder(){
		return properties.getProperty("datafiles");
	}
	
	public static int getPortNumber(){
		return Integer.parseInt(properties.getProperty("portnumber"));
	}
}
