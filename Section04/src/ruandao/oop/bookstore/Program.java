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
				System.out.println("== 增加图书 ==");
				name = Console.inputLine("请输入书名：");
				error =  bookManager.append(new Book(name));
				if( error.equals("") ){
					System.out.println("成功！");
				}
				else{
					System.out.println(error);
				}
					
				break;
			case 2:
				System.out.println( bookManager.list() );
				break;
			case 3:
				System.out.println("== 删除图书 ==");
				name = Console.inputLine("请输入书名：");
				error =  bookManager.remove(name);
				if( error.equals("") ){
					System.out.println("成功！");
				}
				else{
					System.out.println(error);
				}
				break;
			case 4:
				System.out.println("== 借阅图书 ==");
				name = Console.inputLine("请输入书名：");
				error =  bookManager.borrow(name);
				if( error.equals("") ){
					System.out.println("成功！");
				}
				else{
					System.out.println(error);
				}
				break;
			case 5:
				System.out.println("== 归还图书 ==");
				name = Console.inputLine("请输入书名：");
				error =  bookManager.guihuan(name);
				if( error.equals("") ){
					System.out.println("成功！");
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
		System.out.println("1. 新增。");
		System.out.println("2. 查看。");
		System.out.println("3. 删除。");
		System.out.println("4. 借出。");
		System.out.println("5. 归还。");
		System.out.println("0. 退出。");
		System.out.println("请选择：");
	}

}
