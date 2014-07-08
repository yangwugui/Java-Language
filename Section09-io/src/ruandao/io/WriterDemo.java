package ruandao.io;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriterDemo {

	public static void main(String[] args) 
			throws IOException {
		FileWriter fw = new FileWriter("Z:\\Coolman\\Desktop\\xxx\\out.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("春眠不觉晓，\r\n");
		bw.write("处处闻啼鸟。\r\n");
		bw.write("夜来风雨声，\r\n");
		bw.write("花落知多少。\r\n");
		
		bw.close();
		fw.close();
	}

}
