package ruandao.adt.library;
import java.util.Scanner;

import ruandao.utility.Console;
import ruandao.utility.TextArray;

public class Program {
	/*
	static String[] books;
	static String[] states;
	static int[] counts;
	*/
	
	static Book[] books;
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
		books = new Book[MAX_BOOK_AMOUNT];
		
		
//		books[0] = new Book();
//		books[0].name = "Asp.net ����";
//		books[0].state= "�ɽ�";
//		books[0].count = 0;
		books[0] = new Book( "Asp.net ����");
	
		books[1] = new Book();
		books[1].name = "Java ����";
		books[1].state= "�ɽ�";
	
		books[2] = new Book();
		books[2].name = "Struts ����";
		books[2].state= "�ɽ�";
	}

	public static int getIndex(String name){
		for(int i = 0; i<books.length; i++){
			if( name.equals( books[i].name ) ) return i;
		}
		return -1;
	}
	
	public static void guihuan() {
		System.out.println("== �黹ͼ�� ==");
		String name = Console.inputLine("������Ҫ����ͼ�飺");
		int index = getIndex(name);
		if( index == -1){
			System.out.println("��Ǹ����Ҫ�����鲻���������ġ�");
			return;
		}
		
		if( books[index].state.equals("�ѻ�")){
			System.out.println("���Ѿ������Ȿ���ˣ�:)");
			return;
		}
		books[index].state = "�ѻ�";
		System.out.println("лл����ӭ�´��������顣");
	}

	public static void borrow() {
		System.out.println("== ����ͼ�� ==");
		String name = Console.inputLine("������Ҫ���ĵ�ͼ�飺");
		int index = getIndex(name);
		if( index == -1){
			System.out.println("��Ǹ��û���ҵ�������Ҫ���顣");
			return;
		}
		
		if( books[index].state.equals("�ѽ�")){
			System.out.println("��Ǹ����Ҫ�����Ѿ��������ˣ��������������");
			return;
		}
		
		books[index].state = "�ѽ�";
		int count = books[index].count;
		books[index].count = count + 1;
		System.out.println("����ͼ�飬���úá�");
	}

	public static void remove() {
		System.out.println("== ɾ���鼮 ==");
		String name = Console.inputLine("������Ҫ���ٵ�ͼ�����ƣ�");
		int index = getIndex(name);
		if( index == -1){
			System.out.println("��Ǹ�������û���Ȿ�顣");
			return;
		}
		
		if( books[index].state.equals("�ѽ�")){
			System.out.println("��Ǹ���Ȿ���Ѿ�����ˣ��黹��������١�");
			return;
		}
		
		delete(index);
		System.out.println("ͼ��������Ϣ�Ѿ����١�");
	}

	public static void delete(int index) {
		for( int i = index; i<books.length-1; i++){
			books[index] = books[index+1];
			if(books[index+1]==null) break;
		}
		books[books.length-1] = null;
	}

	public static void list() {
		System.out.println("����  ״̬\t ����\t");
		for(int i=0; i<MAX_BOOK_AMOUNT; i++){
			if(books[i]==null) break;
			System.out.println(books[i].name + "\t" + books[i].state + "\t" + books[i].count);
		}
	}

	public static void add() {
		System.out.println("== ����ͼ�� ==");
		String name = Console.inputLine("������������");
		Book book = new Book();
		book.name = name;
		book.state = "�ɽ�";
		append(book);
		System.out.println("ͼ���Ѿ��ɹ���⡣");
	}

	public static void append(Book book) {
		int firstNull = -1;
		for( int i=0; i<books.length; i++){
			if( books[i] == null ){
				firstNull = i;
				break;
			}
		}
		if( firstNull == -1 ){
			System.out.println("�����Ѿ����ˣ��Ų����ˣ�");
		}
		books[firstNull] = book;
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
