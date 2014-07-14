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
//		books[0].name = "Asp.net 入门";
//		books[0].state= "可借";
//		books[0].count = 0;
		books[0] = new Book( "Asp.net 入门");
	
		books[1] = new Book();
		books[1].name = "Java 入门";
		books[1].state= "可借";
	
		books[2] = new Book();
		books[2].name = "Struts 入门";
		books[2].state= "可借";
	}

	public static int getIndex(String name){
		for(int i = 0; i<books.length; i++){
			if( name.equals( books[i].name ) ) return i;
		}
		return -1;
	}
	
	public static void guihuan() {
		System.out.println("== 归还图书 ==");
		String name = Console.inputLine("请输入要还的图书：");
		int index = getIndex(name);
		if( index == -1){
			System.out.println("抱歉，你要还的书不是在这儿借的。");
			return;
		}
		
		if( books[index].state.equals("已还")){
			System.out.println("你已经还过这本书了，:)");
			return;
		}
		books[index].state = "已还";
		System.out.println("谢谢，欢迎下次再来借书。");
	}

	public static void borrow() {
		System.out.println("== 借阅图书 ==");
		String name = Console.inputLine("请输入要借阅的图书：");
		int index = getIndex(name);
		if( index == -1){
			System.out.println("抱歉，没有找到你所需要的书。");
			return;
		}
		
		if( books[index].state.equals("已借")){
			System.out.println("抱歉，你要的书已经被借走了，请过几天再来。");
			return;
		}
		
		books[index].state = "已借";
		int count = books[index].count;
		books[index].count = count + 1;
		System.out.println("给你图书，请拿好。");
	}

	public static void remove() {
		System.out.println("== 删除书籍 ==");
		String name = Console.inputLine("请输入要销毁的图书名称：");
		int index = getIndex(name);
		if( index == -1){
			System.out.println("抱歉，书库中没有这本书。");
			return;
		}
		
		if( books[index].state.equals("已借")){
			System.out.println("抱歉，这本书已经借出了，归还后才能销毁。");
			return;
		}
		
		delete(index);
		System.out.println("图书的相关信息已经销毁。");
	}

	public static void delete(int index) {
		for( int i = index; i<books.length-1; i++){
			books[index] = books[index+1];
			if(books[index+1]==null) break;
		}
		books[books.length-1] = null;
	}

	public static void list() {
		System.out.println("书名  状态\t 次数\t");
		for(int i=0; i<MAX_BOOK_AMOUNT; i++){
			if(books[i]==null) break;
			System.out.println(books[i].name + "\t" + books[i].state + "\t" + books[i].count);
		}
	}

	public static void add() {
		System.out.println("== 增加图书 ==");
		String name = Console.inputLine("请输入书名：");
		Book book = new Book();
		book.name = name;
		book.state = "可借";
		append(book);
		System.out.println("图书已经成功入库。");
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
			System.out.println("货架已经满了，放不下了！");
		}
		books[firstNull] = book;
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
