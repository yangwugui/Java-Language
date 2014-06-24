package ruandao.array.bookstore;
import java.util.Scanner;

import ruandao.utility.Console;
import ruandao.utility.TextArray;

public class Program {
	static String[] books;
	static String[] states;
	static int[] counts;
	
	static int MAX_BOOK_AMOUNT = 20;

	public static void main(String[] args) {
		
		init();
		boolean isExit = false;
		for(;;){
			
			showMenu();
			
			Scanner input = new Scanner(System.in);
			int select = input.nextInt();
			
			switch(select){
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				remove();
				break;
			case 4:
				borrow();
				break;
			case 5:
				guihuan();
				break;
			case 0:
				isExit = true;
				break;
				
			} // switch
			
			if( isExit){
				System.out.println("Bye Bye !");
				break;
			}
			
		} // for

	}

	public static void init() {
		books = new String[MAX_BOOK_AMOUNT];
		states = new String[MAX_BOOK_AMOUNT];
		counts = new int[MAX_BOOK_AMOUNT];
		
		books[0] = "Asp.net ����";
		states[0] = "�ɽ�";
	
		books[1] = "Java ����";
		states[1] = "�ɽ�";
	
		books[2] = "Struts ����";
		states[2] = "�ɽ�";
	}

	public static void guihuan() {
		System.out.println("== �黹ͼ�� ==");
		String name = Console.inputLine("������Ҫ����ͼ�飺");
		int index = TextArray.getIndex(books, name);
		if( index == -1){
			System.out.println("��Ǹ����Ҫ�����鲻���������ġ�");
			return;
		}
		
		if( states[index].equals("�ѻ�")){
			System.out.println("���Ѿ������Ȿ���ˣ�:)");
			return;
		}
		states[index] = "�ѻ�";
		System.out.println("лл����ӭ�´��������顣");
	}

	public static void borrow() {
		System.out.println("== ����ͼ�� ==");
		String name = Console.inputLine("������Ҫ���ĵ�ͼ�飺");
		int index = TextArray.getIndex(books, name);
		if( index == -1){
			System.out.println("��Ǹ��û���ҵ�������Ҫ���顣");
			return;
		}
		
		if( states[index].equals("�ѽ�")){
			System.out.println("��Ǹ����Ҫ�����Ѿ��������ˣ��������������");
			return;
		}
		
		states[index] = "�ѽ�";
		int count = counts[index];
		counts[index] = count + 1;
		System.out.println("����ͼ�飬���úá�");
	}

	public static void remove() {
		System.out.println("== ɾ���鼮 ==");
		String name = Console.inputLine("������Ҫ���ٵ�ͼ�����ƣ�");
		int index = TextArray.getIndex(books, name);
		if( index == -1){
			System.out.println("��Ǹ�������û���Ȿ�顣");
			return;
		}
		
		if( states[index].equals("�ѽ�")){
			System.out.println("��Ǹ���Ȿ���Ѿ�����ˣ��黹��������١�");
			return;
		}
		
		TextArray.removeAt(books, index);
		System.out.println("ͼ��������Ϣ�Ѿ����١�");
	}

	public static void list() {
		System.out.println("����  ״̬\t ����\t");
		for(int i=0; i<MAX_BOOK_AMOUNT; i++){
			if(books[i]==null) break;
			System.out.println(books[i] + "\t" + states[i] + "\t" + counts[i]);
		}
	}

	public static void add() {
		System.out.println("== ����ͼ�� ==");
		String name = Console.inputLine("������������");
		TextArray.append(books,name);
		TextArray.append(states,"�ɽ�");
	}

	public static void showMenu() {
		System.out.println("1. ������");
		System.out.println("2. �鿴��");
		System.out.println("3. ɾ����");
		System.out.println("4. �����");
		System.out.println("5. �黹��");
		System.out.println("0. �˳���");
		System.out.println("��ѡ��");
	}

}
