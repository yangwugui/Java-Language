package ruandao.io;
import java.io.File;
import java.io.IOException;


public class FileMethods {

	public static void main(String[] args) {
		FileMethods fm = new FileMethods();
		File file = new File("d:\\xxx\\test.txt");
		try {
			fm.create(file);
			//fm.delete(file);
		} catch (IOException e) {

			System.out.println("�����ļ�ʧ�ܣ���������һ���ļ�����");
		}
		//System.out.println("�ļ��Ѿ�������ɣ�");
		System.out.println("�ļ��Ѿ��ɹ�ɾ����");
	}
	
	public void create(File file) 
			throws IOException{
		if(!file.exists()){
			file.createNewFile();
		}
	}

	public void delete(File file) 
			throws IOException{
		if(file.exists()){
			file.delete();
		}
	}

}
