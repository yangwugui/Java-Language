package ruandao.math;
import java.util.Random;
import java.util.Scanner;

import ruandao.utility.Console;




public class GuessNumber {

	public static void main(String[] args) {
		Random rd = new Random();
		boolean  toNext = true;
		do{
			int value = rd.nextInt(100);
			int count = guess(value);
			System.out.println("你真棒，太对了！你只猜了" + count + "次");
			
			toNext = Console.confirm("还继续玩吗？输入y继续，输入n结束程序。", 'y');
		}while(toNext);
	}

	private static int guess(int value) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		int x;
		for(;;){
			count ++;
			System.out.println("猜一猜：");
			x = input.nextInt();
			if( x == value){
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
		return count;
	}
	
}
