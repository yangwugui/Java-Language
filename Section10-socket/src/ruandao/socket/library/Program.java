package ruandao.socket.library;

import ruandao.utility.Console;

public class Program {

	static BookManager bookManager = null;
	
	public static void main(String[] args) {
		bookManager = new BookXmlManager();
		
		boolean isExit = false;
		String person = "";
		String name = "";
		for(;;){
			
			String[] menu = {"1. 新增。",
					"2. 查看。",
					"3. 删除。",
					"4. 借出。",
					"5. 归还。",
					"6. 保存。",
					"7. 打开。",
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
					showBooks();
					break;
				case "3":
					System.out.println("== 删除图书 ==");
					name = Console.inputLine("请输入书名：");
					bookManager.remove(name);
					System.out.println("图书的相关信息已经销毁。");
					break;
				case "4":
					System.out.println("== 借阅图书 ==");
					person = Console.inputLine("请输入您的名字：");
					name = Console.inputLine("请输入书名：");
					bookManager.borrow(person, name);
					System.out.println("给你图书，请拿好。");
					break;
				case "5":
					System.out.println("== 归还图书 ==");
					person = Console.inputLine("请输入你的名字：");
					name = Console.inputLine("请输入书名：");
					int days = bookManager.guihuan(person,name);
					System.out.println("您一共接了" + days + "天，租金是" + days + "元。");
					System.out.println("谢谢，欢迎下次再来借书。");
					break;
				case "6":
					System.out.println("== 保存图书 ==");
					String filename = Console.inputLine("请输入文件的路径名：");
					bookManager.save(filename);
					System.out.println("已经成功保存。");
					break;
				case "7":
					System.out.println("== 打开图书 ==");
					String openFile = Console.inputLine("请输入文件的路径名：");
					bookManager.open(openFile);
					System.out.println("已经成功打开。");
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
	
	public static void showBooks() {
		int i = 1;
		for(Book book : bookManager.getAllBooks()){
			System.out.println( i + ". " + book  + "\n" );
			i++;
		}
	}

}
