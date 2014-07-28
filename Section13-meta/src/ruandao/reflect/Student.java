package ruandao.reflect;

public class Student {
	private String name;
	private int age;
	public String toString(){
		return "name is " + name + ", age is " + age + ".";
	}
	
	public int score(String subject){
		if( subject.equals("shuxue")){
			return 100;
		}
		if( subject.equals("wuli")){
			return 90;
		}
		if( subject.equals("huaxue")){
			return 95;
		}
		return 50;
	}
}
