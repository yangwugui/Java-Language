package ruandao.file;

import java.io.File;

public class FilePath {

	public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));  
        
        System.out.println(FilePath.class.getClassLoader().getResource(""));  
  
        System.out.println(ClassLoader.getSystemResource(""));  
        System.out.println(FilePath.class.getResource(""));  
        System.out.println(FilePath.class.getResource("/"));
        //Class�ļ�����·��
        System.out.println(new File("/").getAbsolutePath());  
         System.out.println(new File("").getAbsolutePath());  
       System.out.println(System.getProperty("user.dir"));  
	}

	/* ֱ���ڿ���̨�����е��������eclipse�е�����ǲ�ͬ�ģ�ͬ�����ڿ���̨�е������в�ͬʱ�� new File�õ���·��Ҳ�ǲ�ͬ�ġ�
	 * ���˵����new File��λ�ļ���ʵ���������ǲ����׵ģ��������еĽ�����������У�
	 * 1. �������ļ�����ʹ��classpath��λ����һ�㲻�����jar�С�
	 * 2. �����ݴ洢��ʹ�������ļ����趨�����ļ�ϵͳ�ľ���·����
	 * 
	D:\VocationalCourse\Source On GitHub\Java-Language>java -classpath Section09-io/bin ruandao.file.FilePath
	
	��command��file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/ruandao/file/
	file:/D:/VocationalCourse/Source%20On%20GitHub/Java-Language/Section09-io/bin/
	D:\
	D:\VocationalCourse\Source On GitHub\Java-Language
	
	��command��D:\VocationalCourse\Source On GitHub\Java-Language>
	 */
}
