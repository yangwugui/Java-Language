package ruandao.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student("one"));
		list.add(new Student("two"));
		list.add(new Student("three"));
		
		Iterator<Student> iterator = list.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			// do something with student ...
		}
		
		for( Student student : list){
			// do something with student ...
		}

	}

}
