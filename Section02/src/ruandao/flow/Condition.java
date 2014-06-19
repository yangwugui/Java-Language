package ruandao.flow;
import java.util.*;

public class Condition {

	public static void main(String[] args) {

		int y = 100;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入除数：");
		int x = input.nextInt();
		
		// 1. 条件语句，（不要把它理解成为分支的特例）
		// 有条件的执行某些内容。
		if( x != 0 ){  // 0 != 0  : false
			System.out.println("y/x is " + (y/x));
		}
	}
	
	// 岗哨模式
	public static void someMethod(){
		if( ! true /* condition */ ){
			// statement small block A ...
			return;
		}
		
		// statement big block B ...
	}
}
