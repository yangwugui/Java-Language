package ruandao.flow;
import java.util.Scanner;


public class Select {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("���������(1-5):");
		int grade = input.nextInt();
		switch( grade ){
		case 1:
		case 2:
			System.out.println("��ҳ���");
			break;
		case 3:
			System.out.println("ҪŬ������");
			break;
		case 4:
			System.out.println("�������������֣�");
			break;
		default:
			System.out.println("�����very very Good!");
			break;
		}
	}

}
