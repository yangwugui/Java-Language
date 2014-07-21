package ruandao.xml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class Dom4jDemo {

	public static void main(String[] args) 
			throws DocumentException, IOException {
		SAXReader sax = new SAXReader();
		Document document = sax.read(new File("src/book.xml"));
		Element root = document.getRootElement();

		for(Object o : root.elements()){
			Element e = (Element) o;
			System.out.print( e.attribute("isbn").getText() + ":" );
			System.out.println(e.attribute("title").getText());
			System.out.println( e.getText().trim());
		}
		
        Element newBook = root.addElement( "book" )
            .addAttribute( "isbn", "888-7-2014-088" )
            .addAttribute( "title", "����Ա�ض�����" )
            .addText( "����һ������Ӳ���ɳ�Ϊ���ֵĺ��飬�Ȿ�齫�Ӹ����ϵ߸���Գ���Ĵ�ͳ������" );
        
        OutputFormat format = OutputFormat.createPrettyPrint();
        Writer wr=new OutputStreamWriter( new FileOutputStream("src/output.xml") ,"UTF-8");  
		XMLWriter writer = new XMLWriter( wr );
	    writer.write( document );
	    writer.close();
	}

}
