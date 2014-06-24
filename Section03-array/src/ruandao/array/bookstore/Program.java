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
		
		books[0] = "Asp.net 入门";
		states[0] = "可借";
	
		books[1] = "Java 入门";
		states[1] = "可借";
	
		books[2] = "Struts 入门";
		states[2] = "可借";
	}

	public static void guihuan() {
		System.out.println("== 归还图书 ==");
		String name = Console.inputLine("请输入要还的图书：");
		int index = TextArray.getIndex(books, name);
		if( index == -1){
			System.out.println("抱歉，你要还的书不是在这儿借的。");
			return;
		}
		
		if( states[index].equals("已还")){
			System.out.println("你已经还过这本书了，:)");
			return;
		}
		states[index] = "已还";
		System.out.println("谢谢，欢迎下次再来借书。");
	}

	public static void borrow() {
		System.out.println("== 借阅图书 ==");
		String name = Console.inputLine("请输入要借阅的图书：");
		int index = TextArray.getIndex(books, name);
		if( index == -1){
			System.out.println("抱歉，没有找到你所需要的书。");
			return;
		}
		
		if( states[index].equals("已借")){
			System.out.println("抱歉，你要的书已经被借走了，请过几天再来。");
			return;
		}
		
		states[index] = "已借";
		int count = counts[index];
		counts[index] = count + 1;
		System.out.println("给你图书，请拿好。");
	}

	public static void remove() {
		System.out.println("== 删除书籍 ==");
		String name = Console.inputLine("请输入要销毁的图书名称：");
		int index = TextArray.getIndex(books, name);
		if( index == -1){
			System.out.println("抱歉，书库中没有这本书。");
			return;
		}
		
		if( states[index].equals("已借")){
			System.out.println("抱歉，这本书已经借出了，归还后才能销毁。");
			return;
		}
		
		TextArray.removeAt(books, index);
		System.out.println("图书的相关信息已经销毁。");
	}

	public static void list() {
		System.out.println("书名  状态\t 次数\t");
		for(int i=0; i<MAX_BOOK_AMOUNT; i++){
			if(books[i]==null) break;
			System.out.println(books[i] + "\t" + states[i] + "\t" + counts[i]);
		}
	}

	public static void add() {
		System.out.println("== 增加图书 ==");
		String name = Console.inputLine("请输入书名：");
		TextArray.append(books,name);
		TextArray.append(states,"可借");
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
