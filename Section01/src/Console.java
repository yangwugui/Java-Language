import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("������������֣�");
		String str = scanner.next();
		
		System.out.println("��ã�" + str);
		
		System.out.println("������һ��������");
		int number = scanner.nextInt();
		
		System.out.print("�����������" + number + "\n");
		
		// �Ķ�jdk api�е�PrintStream, Scanner�������ࡣ
	}

}
