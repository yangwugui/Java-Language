package ruandao.utility;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {
	// yes or no, return true if select yes, else return false.
	public static boolean confirm(String prompt, char yesChar){
		System.out.println(prompt);
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		if( str.length()>0 && str.charAt(0)==yesChar ) return true;
		return false;
	}
	
	public static void pause( String prompt ){
		System.out.println(prompt + " �밴�س�������...");
		new Scanner(System.in).nextLine();
	}
	
	// �Ӽ��̻�ȡһ���������������ظ���
	public static int inputInt( String prompt){
		String retryPrompt = "����Ĳ���һ�����������������룺";
		Scanner input = new Scanner(System.in);
		
		System.out.println(prompt);
		for(;;){
			int num = 0;
			try{
				num = input.nextInt();
			}
			catch ( InputMismatchException ex){
				System.out.println(retryPrompt);
				input.nextLine();
				continue;
			}
			return num;
		}
	}
	
	// ����ָ����Χ[min,max]�ڵ���������min��max֮�䣬�Ұ���min��max��
	public static int inputInt( String prompt, int min, int max ){
		String retryPrompt = "����Ĳ���һ�����������������룺";
		Scanner input = new Scanner(System.in);
		
		System.out.println(prompt);
		for(;;){
			int num = 0;
			try{
				num = input.nextInt();
			}
			catch ( InputMismatchException ex){
				System.out.println(retryPrompt);
				input.nextLine();
				continue;
			}
			if( num <min || num > max){
				System.out.println("���������������Χ��" + prompt);
				continue;
			}
			return num;
		}
	}
	
	// �Ӽ��̻�ȡһ���ַ������������ո񣬳������ظ���
	public static String inputString( String prompt){
		String retryPrompt = "������ǿհ��ַ��������������룺";
		Scanner input = new Scanner(System.in);
		
		System.out.println(prompt);
		for(;;){
			String str = input.nextLine();
			if( str.trim().equals("")){
				System.out.println(retryPrompt);
				continue;
			}
			int index = str.indexOf(" ");
			if( index == -1 ) return str;
			return str.substring(0,index);
		}
	}
	
	// �Ӽ��̻�ȡһ�������У����԰����ո񣬳������ظ���
	public static String inputLine( String prompt){
		String retryPrompt = "������ǿհ��ַ��������������룺";
		Scanner input = new Scanner(System.in);
		
		System.out.println(prompt);
		for(;;){
			String str = input.nextLine();
			if( str.trim().equals("")){
				System.out.println(retryPrompt);
				continue;
			}
			return str;
		}
	}
	
	// menu�ַ�������Ϊ����ѡ��ÿһ���˵�, Լ���ַ����ĵ��֮ǰ����ĸΪѡ������Ĳ˵������ַ���
	public static String selectMenu( String[] menu ){
		String retryPrompt = "�����˴���Ĳ˵�����������룺";
		Scanner input = new Scanner(System.in);
		List<String> keys = new ArrayList();
		for( String item : menu){
			System.out.println(item);
			int index = item.indexOf(".");
			keys.add( item.substring(0, index) );
		}
		System.out.println("��ѡ��");
		//System.out.println();
		for(;;){
			String select = input.next();
			if( keys.indexOf(select) == -1){
				System.out.println(retryPrompt);
				continue;
			}
			return select;
		}
	}

	public static BigDecimal inputDecimal(String prompt) {
		String retryPrompt = "������Ч�����������룺";
		Scanner input = new Scanner(System.in);
		
		System.out.println(prompt);
		for(;;){
			BigDecimal decimal = BigDecimal.valueOf(0.0);
			try{
				decimal = new BigDecimal(input.nextLine());
			}
			catch ( NumberFormatException ex){
				System.out.println(retryPrompt);
				continue;
			}
			return decimal;
		}
	}

	public static Date inputDate(String prompt) {
		String retryPrompt = "��������ڸ�ʽ��Ч�����������룺";
		Scanner input = new Scanner(System.in);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(prompt);
		for(;;){
			Date date;
			try{
				date = df.parse(input.next());
			}
			catch(ParseException ex){
				System.out.println(retryPrompt);
				continue;
			}
			return date;
		}
	}

	public static void main(String arg[]){

		
		String select = selectMenu(new String[]{
				"A. AAAAAAAAAAAAAAA",
				"B. BBBBBBBBBBBBBBB",
				"C. CCCCCCCCCCCCCCC",
				"D. DDDDDDDDDDDDDDD",
				"E. EEEEEEEEEEEEEEE"
		} );
		
		System.out.println("ѡ��Ĳ˵��ǣ�" + select );

	}

	public static String inputLine(String prompt, String defaultValue) {
		String retryPrompt = "������ǿհ��ַ��������������룺";
		Scanner input = new Scanner(System.in);
		
		System.out.println(prompt);
		String str = input.nextLine();
		if( str.trim().equals("")){
			str = defaultValue;
		}
		return str;
	}
	
}
