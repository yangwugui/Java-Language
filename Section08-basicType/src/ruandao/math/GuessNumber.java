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
			System.out.println("�������̫���ˣ���ֻ����" + count + "��");
			
			toNext = Console.confirm("��������������y����������n��������", 'y');
		}while(toNext);
	}

	private static int guess(int value) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		int x;
		for(;;){
			count ++;
			System.out.println("��һ�£�");
			x = input.nextInt();
			if( x == value){
				break;
			}
			if(x<value){
				System.out.println("̫С�ˣ��´�㣡");
				continue;
			}
			else{
				System.out.println("̫���ˣ���С�㣡");
				continue;
			}
		}
		return count;
	}
	
}
