package ruandao.flow;
import java.util.*;

public class DoWhile {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = 0;
		
		// loop { } until (...)
		// ѭ����... ֱ��ʲôʲô���˳���
		do{
			System.out.println("������һ����������");
			x = input.nextInt();
		}while( !(x>0) );
		System.out.println("����������ǣ�" + x);
	}

}
