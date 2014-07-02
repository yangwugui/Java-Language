package ruandao.collection;
import java.util.*;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();

		list.add("item one");
		list.add("item two");
		
		list.add(new Student("zhangsan"));
		
		Student s = new Student("Coolman");
		s.setName("Coolman");
		s.setCode("20140001");
		s.setScore(90);
		
		list.add(s);
		
		for(int i=0; i<list.size(); i++){
			if(i>=2){
				Student student = (Student)list.get(i);
				System.out.println("Name is :" + student.getName());
				continue;
			}
			System.out.println("µÚ" + (i+1) + "ÊýÊÇ£º" + list.get(i));
		}
	}

}
