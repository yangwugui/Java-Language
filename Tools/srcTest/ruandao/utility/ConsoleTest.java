package ruandao.utility;

public class ConsoleTest {

	public static void main(String[] args) {
		//TestInputString();
		TestInputInt();
	}
	
	// 1. void
	// 2. ()
	// 3. 不和用户交互，不从用户手里拿数据。
	public static void TestInputString(){
		String expected = "abcd";
		String actual = Console.inputString("请输入字符串abcd:");
		if( expected.equals(actual)){
			System.out.println("测试成功！");
		}
		else System.out.println("测试失败！");
	}

	public static void TestInputInt(){
		int expected = 100;
		int actual = Console.inputInt("请输入整数100:");
		if( actual == expected){
			System.out.println("测试成功！");
		}
		else System.out.println("测试失败！");
	}

}
