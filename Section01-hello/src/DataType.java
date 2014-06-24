
public class DataType {

	public static void main(String[] args) {
		// 优先使用 int
		byte tiny = 127;
		short smallInteger = 450;
		int integer = 100000000;
		long bigInteger = 100000000000L;
		
		// 优先使用double
		float value = 5.6f;
		double bigValue = 6.6;
		
		// 字符 char
		char charactor = 'A';
		charactor = (char) (charactor + 3);
		
		System.out.println(" 'A' + 3 = " + charactor);
		
		// 字符串, String不是关键字，是一个类型名称。
		String str = "abcdefg";
		String str2 = "aaaaaaaa" + "bbbbbbbb"; // str2: "aaaaaaaabbbbbbbbb"
		str = "";  // 这是一个字符串，该字符串的个数为0。"空串", empty字符串。
		str = " "; // 这是一个字符串，该字符串个数为1，是一个空格。
	}

}
