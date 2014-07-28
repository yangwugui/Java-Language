package ruandao.genric;

import java.util.ArrayList;


public class GenricClass<Type> {
	Type t;
	
	public GenricClass(Type t){
		this.t = t;
	}
	
	public String helloWorld(){
		System.out.println("Hello, my name is " + t.toString());
		return t.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher t = new Teacher("Coolman");
		Student s = new Student("Coolman");
		
		GenricClass<Teacher> gt = new GenricClass(t);
		GenricClass<Student> gs = new GenricClass(s);
		
		
		ArrayList<Teacher> list = new ArrayList();
		list.add(t );
		list.remove(0);
		list.get(0);
		
		gt.helloWorld();
		gs.helloWorld();
		
		list.get(0).ToString();
	}

}
