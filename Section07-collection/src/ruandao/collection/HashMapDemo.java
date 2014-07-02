package ruandao.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<String,Student> map = new HashMap<String,Student>();
		
		Student dvd = new Student("º®¾ý");
		
		map.put("coolman", dvd);

		Student d = map.get("coolman");
		
		for(String key : map.keySet()){
			Student item = map.get(key);
		}
		
		for(Student item : map.values()){
			// item....
		}
		
		// Key-Value Pair ¼üÖµ¶Ô
		for(Map.Entry<String, Student> entry : map.entrySet()){
			String name = entry.getKey();
			Student item = entry.getValue();
		}
		
		if( map.containsKey("sommeone")){
			Student luomaDvd = map.get("someone");
		}
		
		map.isEmpty();
		
		map.size();
		map.remove("luoma");
		map.clear();
	}

}
