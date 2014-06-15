import java.util.Scanner;

public class Console {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("请输入你的名字：");
		String str = scanner.next();
		
		System.out.println("你好，" + str);
		
		System.out.println("请输入一个整数：");
		int number = scanner.nextInt();
		
		System.out.print("你输入的数是" + number + "\n");
		
		// 阅读jdk api中的PrintStream, Scanner这两个类。
	}

}
