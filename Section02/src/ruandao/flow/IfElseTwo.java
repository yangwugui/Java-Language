package ruandao.flow;
import java.util.Scanner;
public class IfElseTwo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("������һ������");
		int x = input.nextInt();
		System.out.println("��������һ������");
		int y = input.nextInt();
		
		if( x == y )
		{
			System.out.println("��������ȣ�");
			return;
		}
		
		if( x < y ){
			System.out.println("��һ������ǣ�" + y);
			return;
		}
		
		System.out.println("��һ������ǣ�" + x);
	}
}


