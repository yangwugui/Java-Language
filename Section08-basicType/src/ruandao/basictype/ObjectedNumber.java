package ruandao.basictype;

import ruandao.utility.Console;

public class ObjectedNumber {

	public static void main(String[] args) {
		int x = 100;
		//Integer intObject = Integer.valueOf(100);
		Integer intObject = 100;
		x = intObject;

		String intString = Console.inputString("请输入一个十进制的整数：");
		x = Integer.parseInt(intString);
		
		System.out.println("输入的整数是：" + x);
		
		System.out.println("Integer能表示的最大的数是：" + Integer.MAX_VALUE);
	}

}
