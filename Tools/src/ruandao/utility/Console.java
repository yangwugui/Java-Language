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
		System.out.println(prompt + " �밴�س�������...");
		new Scanner(System.in).nextLine();
	}
	
	// �Ӽ��̻�ȡһ���������������ظ���
	// to do : min max��Ч�Լ��
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
}
