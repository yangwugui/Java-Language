package ruandao.enumtype;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomItemType {
	final public static Map.Entry<String, String> singleType = new AbstractMap.SimpleEntry<String, String>("Single","��ֵ");
	final public static Map.Entry<String, String> listType = new AbstractMap.SimpleEntry<String, String>("List","��ֵ");
	final public static Map.Entry<String, String> arrayType = new AbstractMap.SimpleEntry<String, String>("Array","����");
	
	static List<String> keys = new ArrayList<String>();
	static List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();

	static{
		keys.add("Single");
		list.add(singleType);
		
		keys.add("List");
		list.add(listType);
		
		keys.add("Array");
		list.add(arrayType);
	}
	
	public static String  getValue( String key){
		return list.get(keys.indexOf(key)).getValue();
	}
	
	public static List<Map.Entry<String, String>> getKeyValueList()
	{
		return list;
	}
}
