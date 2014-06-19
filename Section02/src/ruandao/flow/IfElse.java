package ruandao.flow;
import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入一个数：");
		int x = input.nextInt();
		System.out.println("请输入另一个数：");
		int y = input.nextInt();
		
		// 决策语句，程序智能。
		if( x < y ){
			System.out.println("大一点的数是：" + y);
		}
		else if( x == y )
		{
			System.out.println("两个数相等！");
		}
		else{
			System.out.println("大一点的数是：" + x);
		}
		
		//语法格式：  值为boolean的表达式 ？ 表达式 A ：表达式B
		
		String str = (x>y) ? "aaaa" : "bbbb";
	
		// 等效于：
		String str2;
		if( x>y )
			str2 = "aaaa";
		else
			str2 = "bbbb";
	}
	
	// 这是一个很深的嵌套结构，并非并列的。
	public static void nested(){
		if(true){
			if(true){

				// statement 111;
				// statement 222;
			}
		}
		else if(true){
				// statement 1;
				// statement 2;
		}
		else if(true) {
				// statement a;
				// statement b;
		}
		else if(true) {
			// statement a;
			// statement b;
		}
		else if(true) {
			// statement a;
			// statement b;
		}
		else{
			
		}
		
		System.out.println();
	}
}

