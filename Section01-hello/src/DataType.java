
public class DataType {

	public static void main(String[] args) {
		// ����ʹ�� int
		byte tiny = 127;
		short smallInteger = 450;
		int integer = 100000000;
		long bigInteger = 100000000000L;
		
		// ����ʹ��double
		float value = 5.6f;
		double bigValue = 6.6;
		
		// �ַ� char
		char charactor = 'A';
		charactor = (char) (charactor + 3);
		
		System.out.println(" 'A' + 3 = " + charactor);
		
		// �ַ���, String���ǹؼ��֣���һ���������ơ�
		String str = "abcdefg";
		String str2 = "aaaaaaaa" + "bbbbbbbb"; // str2: "aaaaaaaabbbbbbbbb"
		str = "";  // ����һ���ַ��������ַ����ĸ���Ϊ0��"�մ�", empty�ַ�����
		str = " "; // ����һ���ַ��������ַ�������Ϊ1����һ���ո�
	}

}
