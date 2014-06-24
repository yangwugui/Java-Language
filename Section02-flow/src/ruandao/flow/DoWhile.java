package ruandao.flow;
import java.util.*;

public class DoWhile {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = 0;
		
		// loop { } until (...)
		// 循环，... 直到什么什么就退出。
		do{
			System.out.println("请输入一个正整数：");
			x = input.nextInt();
		}while( !(x>0) );
		System.out.println("输入的整数是：" + x);
	}

}
