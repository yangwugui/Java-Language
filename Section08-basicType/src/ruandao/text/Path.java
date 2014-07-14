package ruandao.text;

public class Path {

	public static void main(String[] args) {
		String path1 = "d:\\abcd\\def";
		String path2 = "xyz\\picture.jpg";
		String path = combine(path1, path2);
		String filename = getFilename(path);
		
		System.out.println("path: " + path);
		System.out.println("filename: " + filename);
	}
	
	// 正确拼接路径字符串，确保两个路径拼接处有且只有一个斜杠。
	public static String combine(String path1, String path2){
		String path = path1;
		if( !path.endsWith("\\") ) path += "\\";
		if( path2.startsWith("\\") ) path2 = path2.substring(1);
		return path + path2;
	}
	
	// 取出不带路径的文件名和扩展名。
	public static String getFilename(String pathFile){
		int index = pathFile.lastIndexOf("\\");
		// index == -1, 那么正好返回pathFile本身。
		return pathFile.substring(index+1);
	}

}
