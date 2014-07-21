package ruandao.file;

import java.io.File;

public class FilePath {

	public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));  
        
        System.out.println(FilePath.class.getClassLoader().getResource(""));  
  
        System.out.println(ClassLoader.getSystemResource(""));  
        System.out.println(FilePath.class.getResource(""));  
        System.out.println(FilePath.class.getResource("/"));
        //Class文件所在路径
        System.out.println(new File("/").getAbsolutePath());  
         System.out.println(new File("").getAbsolutePath());  
       System.out.println(System.getProperty("user.dir"));  
	}

	/* 直接在控制台中运行的输出和在eclipse中的输出是不同的，同样是在控制台中当命令行不同时用 new File得到的路径也是不同的。
	 * 因此说：用new File定位文件在实际生产中是不靠谱的！在生产中的解决方案有两招：
	 * 1. 对配置文件而言使用classpath定位，但一般不打包到jar中。
	 * 2. 对数据存储，使用配置文件来设定基于文件系统的绝对路径。
	 * 
	D:\VocationalCourse\Source On GitHub\Java-Language>java -classpath Section09-io/bin ruandao.file.FilePath
	
	【command】file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/ruandao/file/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	D:\
	D:\VocationalCourse\Source On GitHub\Java-Language
	
	【command】D:\VocationalCourse\Source On GitHub\Java-Language>
	 */
}
