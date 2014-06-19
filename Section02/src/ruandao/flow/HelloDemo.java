package ruandao.flow;
import java.util.*;

public class HelloDemo {

	public static void main(String[] args) {

		boolean flag;
		flag = (4==5);
		if(flag)
		{
			System.out.println("Hello, True!");
		}
		String[] a = new String[]{"aa", "bbb"};
		String s = a[0];
		System.out.println(s);
	}
	
	public static int max( int a, int b, int c){
		int result = 0;
		if( a > b){
			if( b>c){
				result = a;
			}
		}
		
		if( a>b && b>c) result = a;
		
		return result;
	}
	
	public static String method(int score){
		switch( score){
		case 1:
			return "very bad!";
		case 2: 
			return "bad";
		case 3:
			return "normal";
		case 4:
			return "good";
		case 5:
			return "very good!";
		}
		return "";
	}
	public static String select(int score){
		String result = "";
		do{
			if(score== 1 ){
				result = "very bad!";
				break;
			}
			if(score== 2 ) {
				result = "bad";
				break;
			}
			if(score== 3 ){
				result = "normal";
				break;
			}
			if(score== 4 ){
				result = "good";
				break;
			}
			if(score== 5 ){
				result = "very good!";
				break;
			}
		}while(false);
		
		return result;
	}
	
	public static void elseif(){
		int x = 0;
		if( x<50 ){
			int a = 0;
			int y = 0;
		}
		else{
			if (x<60){
			}

			else if( x<70){
			
			}
			else if( x<90){
			
			}
			else{
				System.out.println("good good...");
			}
		}
	}
	
	
}
