package ruandao.utility;

public class ConsoleTest {

	public static void main(String[] args) {
		//TestInputString();
		TestInputInt();
	}
	
	// 1. void
	// 2. ()
	// 3. �����û������������û����������ݡ�
	public static void TestInputString(){
		String expected = "abcd";
		String actual = Console.inputString("�������ַ���abcd:");
		if( expected.equals(actual)){
			System.out.println("���Գɹ���");
		}
		else System.out.println("����ʧ�ܣ�");
	}

	public static void TestInputInt(){
		int expected = 100;
		int actual = Console.inputInt("����������100:");
		if( actual == expected){
			System.out.println("���Գɹ���");
		}
		else System.out.println("����ʧ�ܣ�");
	}

}
