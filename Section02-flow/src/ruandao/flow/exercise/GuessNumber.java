package ruandao.flow.exercise;
import java.util.Random;
import java.util.Scanner;




public class GuessNumber {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner input = new Scanner(System.in);
		int value = rd.nextInt(100);
		int x;
		int count = 0;
		for(;;){
			count ++;
			System.out.println("猜一猜：");
			x = input.nextInt();
			if( x == value){
				System.out.println("你真棒，太对了！你只猜了" + count + "次");
				break;
			}
			if(x<value){
				System.out.println("太小了，猜大点！");
				continue;
			}
			else{
				System.out.println("太大了，猜小点！");
				continue;
			}
		}
	}


}
