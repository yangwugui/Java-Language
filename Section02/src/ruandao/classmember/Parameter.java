package ruandao.classmember;

public class Parameter {

	public static void main(String[] args) {
		int value = 50;
		add(value);
		System.out.println("x value is: " + value);
	}
	
	public static void add(int x){
		x = x + 100;
		System.out.println("x value is: " + x);
	}

}
