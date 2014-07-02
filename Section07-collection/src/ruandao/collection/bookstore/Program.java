package ruandao.collection.bookstore;

import ruandao.utility.Console;

public class Program {

	public static void main(String[] args) {
		int MAX_BOOK_AMOUNT = 20;
		//BookManager bookManager = new BookMapManager(MAX_BOOK_AMOUNT);
		//BookManager bookManager = new BookListManager(MAX_BOOK_AMOUNT);
		BookManager bookManager = new BookArrayManager(MAX_BOOK_AMOUNT);
		
		try{
			bookManager.init();
		}
		catch(Exception ex){
			// ignore err!
		}
		
		boolean isExit = false;
		String name = "";
		for(;;){
			
			String[] menu = {"1. 新增。",
					"2. 查看。",
					"3. 删除。",
					"4. 借出。",
					"5. 归还。",
					"0. 退出。" };
			String select = Console.selectMenu(menu);
			try{
				switch(select){
				case "1":
					System.out.println("== 增加图书 ==");
					name = Console.inputLine("请输入书名：");
					bookManager.add(new Book(name));
					System.out.println("图书已经成功入库。");
					break;
				case "2":
					System.out.println( bookManager.list() );
					break;
				case "3":
					System.out.println("== 删除图书 ==");
					name = Console.inputLine("请输入书名：");
					bookManager.remove(name);
					System.out.println("图书的相关信息已经销毁。");
					break;
				case "4":
					System.out.println("== 借阅图书 ==");
					name = Console.inputLine("请输入书名：");
					bookManager.borrow(name);
					System.out.println("给你图书，请拿好。");
					break;
				case "5":
					System.out.println("== 归还图书 ==");
					name = Console.inputLine("请输入书名：");
					bookManager.guihuan(name);
					System.out.println("谢谢，欢迎下次再来借书。");
					break;
				case "0":
					isExit = true;
					break;
					
				} // switch
			}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
			
			if( isExit){
				System.out.println("Bye Bye !");
				break;
			}
			
		} // for

	}

}
