package ruandao.classmember;
import java.util.Scanner;


public class Method {

	public static void main(String[] args) {
		printShape();
		System.out.println();
		
		//returnDemo();
		
		int number ;
		number = returnDemo() + 99;
		System.out.println("number is: " + number);
		
		Scanner input = new Scanner(System.in);
		int one = input.nextInt();
		int two = input.nextInt();
		
		System.out.println("���������ĺ���" + add(one,two) );
	}
	
	public static void printShape(){
		System.out.println("   *   ");
		System.out.println("  ***  ");
		System.out.println(" ***** ");
		System.out.println("  ***  ");
		System.out.println("   *   ");
	}
	
	public static int returnDemo(){
		int x = 100;
		int y = 200;
		System.out.println("һ������100+200�ķ�����");
		return x + y;
	}
	
	public static int add(int x, int y){
		return x+y;
	}
	
	public static int sum(int number){
		if( number==1) return 1;
		else return number + sum(number-1);
	}

}
