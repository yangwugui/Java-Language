package ruandao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(new File("src/demo.ini"));
		properties.load(fis);

		System.out.println("name is: " + properties.getProperty("name"));
		System.out.println("author is: " + properties.getProperty("author"));
	}

}
