package ruandao.flow;
import java.util.Scanner;

public class BooleanData {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入一个数：");
		int x = input.nextInt();
		System.out.println("请输入另一个数：");
		int y = input.nextInt();
		System.out.println("请输入第三个数：");
		int z = input.nextInt();
		boolean isOk;  // true, false
		isOk = ( x < y );
		
		// 1. isOk = true;  false
		// 2. isOk = x < y
		// 3. 并且&&， 或者||， 不是!
		
		if( (x>y) || (x>z) ){
			System.out.println("最大数是：" + x);
		}
		if( y>x && y>z ){
			System.out.println("最大数是：" + y);
		}
		if( z>y && z>x ){
			System.out.println("最大数是：" + z);
		}
	}
}

