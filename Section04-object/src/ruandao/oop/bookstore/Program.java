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
			
			String[] menu = {"1. 新增。",
					"2. 查看。",
					"3. 删除。",
					"4. 借出。",
					"5. 归还。",
					"0. 退出。" };
			String select = Console.selectMenu(menu);
			
			switch(select){
			case "1":
				System.out.println("== 增加图书 ==");
				name = Console.inputLine("请输入书名：");
				msg = bookManager.append(new Book(name));
				System.out.println(msg);
				break;
			case "2":
				System.out.println( bookManager.list() );
				break;
			case "3":
				System.out.println("== 删除图书 ==");
				name = Console.inputLine("请输入书名：");
				msg =  bookManager.remove(name);
				System.out.println(msg);
				break;
			case "4":
				System.out.println("== 借阅图书 ==");
				name = Console.inputLine("请输入书名：");
				msg =  bookManager.borrow(name);
				System.out.println(msg);
				break;
			case "5":
				System.out.println("== 归还图书 ==");
				name = Console.inputLine("请输入书名：");
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
