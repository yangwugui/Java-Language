package ruandao.oop.bookstore;
import java.util.Scanner;

import ruandao.utility.Console;
import ruandao.utility.TextArray;

public class Program {

	public static void main(String[] args) {
		int MAX_BOOK_AMOUNT = 20;
		BookManager bookManager = new BookManager(MAX_BOOK_AMOUNT);
		
		bookManager.init();
		boolean isExit = false;
		String error = "";
		String name = "";
		for(;;){
			
			showMenu();
			
			Scanner input = new Scanner(System.in);
			int select = input.nextInt();
			
			switch(select){
			case 1:
				System.out.println("== ����ͼ�� ==");
				name = Console.inputLine("������������");
				error =  bookManager.append(new Book(name));
				if( error.equals("") ){
					System.out.println("�ɹ���");
				}
				else{
					System.out.println(error);
				}
					
				break;
			case 2:
				System.out.println( bookManager.list() );
				break;
			case 3:
				System.out.println("== ɾ��ͼ�� ==");
				name = Console.inputLine("������������");
				error =  bookManager.remove(name);
				if( error.equals("") ){
					System.out.println("�ɹ���");
				}
				else{
					System.out.println(error);
				}
				break;
			case 4:
				System.out.println("== ����ͼ�� ==");
				name = Console.inputLine("������������");
				error =  bookManager.borrow(name);
				if( error.equals("") ){
					System.out.println("�ɹ���");
				}
				else{
					System.out.println(error);
				}
				break;
			case 5:
				System.out.println("== �黹ͼ�� ==");
				name = Console.inputLine("������������");
				error =  bookManager.guihuan(name);
				if( error.equals("") ){
					System.out.println("�ɹ���");
				}
				else{
					System.out.println(error);
				}
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
