package ruandao.flow;
import java.util.*;

public class Condition {

	public static void main(String[] args) {

		int y = 100;
		Scanner input = new Scanner(System.in);
		System.out.println("�����������");
		int x = input.nextInt();
		
		// 1. ������䣬����Ҫ��������Ϊ��֧��������
		// ��������ִ��ĳЩ���ݡ�
		if( x != 0 ){  // 0 != 0  : false
			System.out.println("y/x is " + (y/x));
		}
	}
	
	// ����ģʽ
	public static void someMethod(){
		if( ! true /* condition */ ){
			// statement small block A ...
			return;
		}
		
		// statement big block B ...
	}
}
