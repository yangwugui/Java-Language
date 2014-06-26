package ruandao.oop.bookstore;

import ruandao.utility.Console;

public class Program {

	public static void main(String[] args) {
		int MAX_BOOK_AMOUNT = 20;
		BookManager bookManager = new BookManager(MAX_BOOK_AMOUNT);
		
		bookManager.init();
		boolean isExit = false;
		String msg = "";
		String name = "";
		for(;;){
			
			String[] menu = {"1. ������",
					"2. �鿴��",
					"3. ɾ����",
					"4. �����",
					"5. �黹��",
					"0. �˳���" };
			String select = Console.selectMenu(menu);
			
			switch(select){
			case "1":
				System.out.println("== ����ͼ�� ==");
				name = Console.inputLine("������������");
				msg = bookManager.append(new Book(name));
				System.out.println(msg);
				break;
			case "2":
				System.out.println( bookManager.list() );
				break;
			case "3":
				System.out.println("== ɾ��ͼ�� ==");
				name = Console.inputLine("������������");
				msg =  bookManager.remove(name);
				System.out.println(msg);
				break;
			case "4":
				System.out.println("== ����ͼ�� ==");
				name = Console.inputLine("������������");
				msg =  bookManager.borrow(name);
				System.out.println(msg);
				break;
			case "5":
				System.out.println("== �黹ͼ�� ==");
				name = Console.inputLine("������������");
				msg =  bookManager.guihuan(name);
				System.out.println(msg);
				break;
			case "0":
				isExit = true;
				break;
				
			} // switch
			
			if( isExit){
				System.out.println("Bye Bye !");
				break;
			}
			
		} // for

	}

}
