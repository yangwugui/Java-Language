

import ruandao.utility.Console;

//import ruandao.utility.Console;

public class Import {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = ruandao.utility.Console.inputInt("请输入一个整数：");
		int y = ruandao.utility.Console.inputInt("请输入第二个整数：");
		
		int sum = x+y;
		
		System.out.println("这两个数的和是" + sum);
	}

}
