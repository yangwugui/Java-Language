package ruandao.classmember;
import java.util.Scanner;


public class InputUtility {
	public static int inputInteger(){
		int x = 0;

		Scanner input = new Scanner(System.in);
		
		for(;;){
			System.out.println("������һ������������");
			x = input.nextInt();
			if (x>0) break;
			System.out.println("����0�͸����ǷǷ��ģ�����һ�Ρ�");
		}
		return x;
	}
}
