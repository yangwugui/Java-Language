package ruandao.math;
import java.util.Random;
import java.util.Scanner;


public class RandomDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		for(;;){
			System.out.println("����Y,������һ��������������˳�����");
			String yes = input.next();
			if( yes.equals("Y") || yes.equals("y")){
				System.out.println("�������" + (1 + random.nextInt(33)));
			}
		}
	}

}
