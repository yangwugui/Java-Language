package ruandao.flow;
import java.util.Scanner;

public class BooleanData {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("������һ������");
		int x = input.nextInt();
		System.out.println("��������һ������");
		int y = input.nextInt();
		System.out.println("���������������");
		int z = input.nextInt();
		boolean isOk;  // true, false
		isOk = ( x < y );
		
		// 1. isOk = true;  false
		// 2. isOk = x < y
		// 3. ����&&�� ����||�� ����!
		
		if( (x>y) || (x>z) ){
			System.out.println("������ǣ�" + x);
		}
		if( y>x && y>z ){
			System.out.println("������ǣ�" + y);
		}
		if( z>y && z>x ){
			System.out.println("������ǣ�" + z);
		}
	}
}

