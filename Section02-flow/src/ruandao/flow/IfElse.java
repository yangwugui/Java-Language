package ruandao.flow;
import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("������һ������");
		int x = input.nextInt();
		System.out.println("��������һ������");
		int y = input.nextInt();
		
		// ������䣬�������ܡ�
		if( x < y ){
			System.out.println("��һ������ǣ�" + y);
		}
		else if( x == y )
		{
			System.out.println("��������ȣ�");
		}
		else{
			System.out.println("��һ������ǣ�" + x);
		}
		
		//�﷨��ʽ��  ֵΪboolean�ı��ʽ �� ���ʽ A �����ʽB
		
		String str = (x>y) ? "aaaa" : "bbbb";
	
		// ��Ч�ڣ�
		String str2;
		if( x>y )
			str2 = "aaaa";
		else
			str2 = "bbbb";
	}
	
	// ����һ�������Ƕ�׽ṹ�����ǲ��еġ�
	public static void nested(){
		if(true){
			if(true){

				// statement 111;
				// statement 222;
			}
		}
		else if(true){
				// statement 1;
				// statement 2;
		}
		else if(true) {
				// statement a;
				// statement b;
		}
		else if(true) {
			// statement a;
			// statement b;
		}
		else if(true) {
			// statement a;
			// statement b;
		}
		else{
			
		}
		
		System.out.println();
	}
}

