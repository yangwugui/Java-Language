package ruandao.math;
import java.util.Random;
import java.util.Scanner;


public class RandomDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		for(;;){
			System.out.println("输入Y,生成下一个随机数，否则退出程序。");
			String yes = input.next();
			if( yes.equals("Y") || yes.equals("y")){
				System.out.println("随机数：" + (1 + random.nextInt(33)));
			}
		}
	}

}
