package ruandao.flow;
import java.util.Scanner;
public class IfElseTwo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入一个数：");
		int x = input.nextInt();
		System.out.println("请输入另一个数：");
		int y = input.nextInt();
		
		if( x == y )
		{
			System.out.println("两个数相等！");
			return;
		}
		
		if( x < y ){
			System.out.println("大一点的数是：" + y);
			return;
		}
		
		System.out.println("大一点的数是：" + x);
	}
}


