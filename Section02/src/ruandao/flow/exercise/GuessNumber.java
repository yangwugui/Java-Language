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
			System.out.println("��һ�£�");
			x = input.nextInt();
			if( x == value){
				System.out.println("�������̫���ˣ���ֻ����" + count + "��");
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
	}


}
