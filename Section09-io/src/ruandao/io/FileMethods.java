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

			System.out.println("创建文件失败，请输入另一个文件名。");
		}
		//System.out.println("文件已经创建完成！");
		System.out.println("文件已经成功删除！");
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
