package ruandao.utility;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {
	// yes or no, return true if select yes, else return false.
	public static boolean confirm(String prompt, char yesChar){
		System.out.println(prompt);
		Scanner input = new Scanner(System.in);
		String str = input.next();
		if( str.length()>0 && str.charAt(0)==yesChar ) return true;
		return false;
	}
	
	public static void pause( String prompt ){
		System.out.println(prompt + " 请按回车键继续...");
		new Scanner(System.in).nextLine();
	}
	
	// 从键盘获取一个整数，出错则重复。
	// to do : min max有效性检测
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
}
