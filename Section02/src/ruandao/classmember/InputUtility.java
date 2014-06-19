package ruandao.classmember;
import java.util.Scanner;


public class InputUtility {
	public static int inputInteger(){
		int x = 0;

		Scanner input = new Scanner(System.in);
		
		for(;;){
			System.out.println("请输入一个非零整数：");
			x = input.nextInt();
			if (x>0) break;
			System.out.println("输入0和负数是非法的，再来一次。");
		}
		return x;
	}
}
