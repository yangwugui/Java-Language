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
		System.out.println(prompt + " 请按回车键继续...");
		new Scanner(System.in).nextLine();
	}
	
	// 从键盘获取一个整数，出错则重复。
	public static int inputInt( String prompt){
		String retryPrompt = "输入的不是一个整数，请重新输入：";
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
	
	// 输入指定范围[min,max]内的整数，在min到max之间，且包含min和max。
	public static int inputInt( String prompt, int min, int max ){
		String retryPrompt = "输入的不是一个整数，请重新输入：";
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
				System.out.println("输入的整数超出范围。" + prompt);
				continue;
			}
			return num;
		}
	}
	
	// 从键盘获取一个字符串，不包含空格，出错则重复。
	public static String inputString( String prompt){
		String retryPrompt = "输入的是空白字符串，请重新输入：";
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
	
	// 从键盘获取一个输入行，可以包含空格，出错则重复。
	public static String inputLine( String prompt){
		String retryPrompt = "输入的是空白字符串，请重新输入：";
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
	
	// menu字符串数组为可以选择每一个菜单, 约定字符串的点号之前的字母为选择输入的菜单项编号字符。
	public static String selectMenu( String[] menu ){
		String retryPrompt = "输入了错误的菜单项，请重新输入：";
		Scanner input = new Scanner(System.in);
		List<String> keys = new ArrayList();
		for( String item : menu){
			System.out.println(item);
			int index = item.indexOf(".");
			keys.add( item.substring(0, index) );
		}
		System.out.println("请选择：");
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
		String retryPrompt = "输入无效，请重新输入：";
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
		String retryPrompt = "输入的日期格式无效，请重新输入：";
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
		
		System.out.println("选择的菜单是：" + select );

	}

	public static String inputLine(String prompt, String defaultValue) {
		String retryPrompt = "输入的是空白字符串，请重新输入：";
		Scanner input = new Scanner(System.in);
		
		System.out.println(prompt);
		String str = input.nextLine();
		if( str.trim().equals("")){
			str = defaultValue;
		}
		return str;
	}
	
}
