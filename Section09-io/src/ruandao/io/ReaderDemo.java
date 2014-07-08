package ruandao.io;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReaderDemo {

	public static void main(String[] args)
			throws FileNotFoundException,IOException {
		FileReader fr = new FileReader("Z:\\Coolman\\Desktop\\xxx\\hello.txt");
		
		BufferedReader br = new BufferedReader(fr);
		//BufferedReader br = new BufferedReader(
		//		new FileReader("Z:\\Coolman\\Desktop\\xxx\\hello.txt") );
		
		try {
			String line = br.readLine();  // ""  ²»ÊÇ "\n"
			
			while(line!=null){
				System.out.println(line);
				line = br.readLine();
			}
			
		}
		finally {
			if( br!=null ) br.close();
			if( fr!=null ) fr.close();
		}

	}

}
