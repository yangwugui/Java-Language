package ruandao.io;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriterDemo {

	public static void main(String[] args) 
			throws IOException {
		FileWriter fw = new FileWriter("Z:\\Coolman\\Desktop\\xxx\\out.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("���߲�������\r\n");
		bw.write("����������\r\n");
		bw.write("ҹ����������\r\n");
		bw.write("����֪���١�\r\n");
		
		bw.close();
		fw.close();
	}

}
