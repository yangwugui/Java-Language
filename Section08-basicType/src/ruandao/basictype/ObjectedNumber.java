package ruandao.basictype;

import ruandao.utility.Console;

public class ObjectedNumber {

	public static void main(String[] args) {
		int x = 100;
		//Integer intObject = Integer.valueOf(100);
		Integer intObject = 100;
		x = intObject;

		String intString = Console.inputString("������һ��ʮ���Ƶ�������");
		x = Integer.parseInt(intString);
		
		System.out.println("����������ǣ�" + x);
		
		System.out.println("Integer�ܱ�ʾ���������ǣ�" + Integer.MAX_VALUE);
	}

}
