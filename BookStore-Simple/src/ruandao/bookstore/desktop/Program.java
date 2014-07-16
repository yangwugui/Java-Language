package ruandao.bookstore.desktop;

import java.math.BigDecimal;

import ruandao.bookstore.Account;
import ruandao.bookstore.Book;
import ruandao.bookstore.PurchasedItem;
import ruandao.bookstore.server.AccountManager;
import ruandao.bookstore.server.BookManager;
import ruandao.bookstore.server.PurchasedItemManager;
import ruandao.utility.Console;

//客户端类
public class Program {
	static final int EXIT_PROGRAM = 0;
	static final int LOGIN_VIEW = 1;
	static final int ADMIN_VIEW = 2;
	static final int ORDER_VIEW = 3;
	
	static Account currentUser = null;
	
    static BookManager bookManager = null; 
    static AccountManager accountManager = null;
	
	// 控制器，负责界面之间的跳转
	public static void main(String[] args) 
			throws Exception {
	    
		System.out.println("欢迎光临软道书店！");
		bookManager = new BookManager("Data Files/");
		accountManager = new AccountManager("Data Files/");
		int view = LOGIN_VIEW;
		do{
			switch (view){
				case LOGIN_VIEW:
					view = showLoginView();
					break;
				case ADMIN_VIEW:
					view = showAdminView();
					break;
				case ORDER_VIEW:
					view = showOrderView();
					break;
			}
		}while(view != EXIT_PROGRAM);
		System.out.println("谢谢光临，欢迎下次再来软道书店！");
	}
	
	public static int showLoginView(){
		String choise = Console.selectMenu(new String[]{"1. 登录","0. 退出系统"});
		if( choise.equals("0") ){
			return EXIT_PROGRAM;
		}
		for(;;){
			String name = Console.inputString("用户名称：");
			String password = Console.inputString("用户密码：");
			try{
				currentUser = accountManager.login(name, password);
			}
			catch(Exception exc){
				System.out.println(exc.getMessage());
				boolean exit = Console.confirm("登录失败，输入 y 退出系统，按回车继续。", 'y');
				if( exit ){
					return EXIT_PROGRAM;
				}
				continue;
			}
			break;//exit for
		}// for(;;)
		if( currentUser.getIsAdmin()) return ADMIN_VIEW;
		return ORDER_VIEW;
	}
	
	public static int showAdminView(){
		System.out.println("图书库存管理");
		String isbn;
		Book book;
		int number;
		for(;;){
			String choise = Console.selectMenu(new String[]{
					"1. 图书入库",
					"2. 图书出库",
					"3. 新增图书",
					"4. 查看全部的图书",
					"5. 查找指定ISBN的图书",
					"6. 根据分类、书名、作者和出版社等信息搜索图书",
					"7. 注销，并返回登录界面",
					"0. 退出系统"});
			switch(choise){
			case "1":
				isbn = Console.inputLine("请输入图书编号：");
				book = bookManager.fetchBook(isbn);
				if( book == null ){
					System.out.println("图书编号不存在，请重新输入。");
					listBooks(bookManager.getAllBooks());
					break;
				}
				number = Console.inputInt("请输入入库数量：");
				bookManager.addBook(isbn, number);
				break;
				
			case "2":
				isbn = Console.inputLine("请输入图书编号：");
				book = bookManager.fetchBook(isbn);
				if( book == null ){
					System.out.println("图书编号不存在，请重新输入。");
					listBooks(bookManager.getAllBooks());
					break;
				}
				for(;;){
					number = Console.inputInt("请输入出库数量：");
					if( book.getAmount() >= number ) break;
					showBook(book);
					System.out.println("数量不足，请重新输入：");
				}
				bookManager.removeBook(isbn, number);
				break;
				
			case "3":
				for(;;){
					isbn = Console.inputLine("请输入图书编号：");
					book = bookManager.fetchBook(isbn);
					if( book == null ) break;
					showBook(book);
					System.out.println("图书编号已经存在，请重新输入。");
				}
				
				book = new Book();
				book.setISBN(isbn);
				book.setTitle(Console.inputLine("请输入图书的标题："));
				book.setAuthor(Console.inputLine("请输入作者的姓名："));
				book.setPublisher(Console.inputLine("请输入出版社："));
				book.setReleaseDate(Console.inputDate("请输入出版日期："));
				book.setPrice(Console.inputDecimal("请输入价格："));
				book.setCoverImage(Console.inputLine("请输入封面图片文件名："));
				book.setAmount(Console.inputInt("请输入入库数量："));
				book.setIntroduction(Console.inputLine("请输入图书的内容简介："));

				bookManager.newBook(book);
				break;
				
			case "4":
				listBooks(bookManager.getAllBooks());
				break;
				
			case "5":
				isbn = Console.inputLine("请输入图书编号：");
				book = bookManager.fetchBook(isbn);
				if( book == null ){
					System.out.println("图书编号不存在。");
				}
				else {
					showBook(book);
				}
				break;
				
			case "6":
				String search = Console.inputLine("输入要查找的关键字：");
				listBooks(bookManager.searchBooks( search));
				break;
				
			case "7":
				try {
					bookManager.writeToXmlFile();
				} catch (Exception e) {
					System.out.println("发生内部错误，数据无法保存到磁盘上，丢失了当前录入的库存数据，需要重新输入。");;
				}
				currentUser = null;
				return LOGIN_VIEW;
				
			case "0":
				try {
					bookManager.writeToXmlFile();
				} catch (Exception e) {
					System.out.println("发生内部错误，数据无法保存到磁盘上，丢失了当前录入的库存数据，需要重新输入。");;
					System.out.println("详细错误信息是：" + e.getMessage());
				}
				return EXIT_PROGRAM;
			}
		}//for(;;)
	}

	public static void listBooks(Book[] bookList) {
		System.out.println("图书列表");
		System.out.println("ISBN   \t数量     \t书名        \t作者         \t出版社");

		for(  Book book : bookList){
			System.out.print(book.getISBN());
			System.out.print("\t" + book.getAmount());
			System.out.print("\t" + book.getTitle());
			System.out.print("\t" + book.getAuthor());
			System.out.print("\t" + book.getPublisher());
			System.out.println();
		}
	}

	public static void showBook(Book book) {
		System.out.println("ISBN   \t数量      \t书名        \t作者         \t出版社");
		System.out.print(book.getISBN());
		System.out.print("\t" + book.getAmount());
		System.out.print("\t" + book.getTitle());
		System.out.print("\t" + book.getAuthor());
		System.out.print("\t" + book.getPublisher());
		System.out.println();
	}

	public static int showOrderView(){
		System.out.println("订单管理");
		
		PurchasedItemManager purchasedItemManager = new PurchasedItemManager();
		
		for(;;){
			showPurchasedItems(purchasedItemManager.getAllItems().values().toArray(new PurchasedItem[0]));
			String choise = Console.selectMenu(new String[]{
					"1. 选择一本图书",
					"2. 修改图书数量",
					"3. 提交的提单",
					"4. 注销，并返回登录界面",
					"0. 退出系统"});
			switch(choise){
			case "1":
				purchasedItemManager.select(selectBook());
				break;
				
			case "2":
				int number = Console.inputInt("请输入购买的数量：",0,100);
				purchasedItemManager.setAmount(selectBook(), number);
				break;
				
			case "3":
				purchasedItemManager = new PurchasedItemManager();
				return ORDER_VIEW;
				
			case "4":
				currentUser = null;
				return LOGIN_VIEW;
				
			case "0":
				return EXIT_PROGRAM;
			}
		}//for(;;)
	}
	
	private static void showPurchasedItems(PurchasedItem[] purchasedItems) {
		System.out.println("isbn  \t单价    \t数量     \t价格");
		BigDecimal sum = new BigDecimal(0);
		for( PurchasedItem detail : purchasedItems){
			System.out.print(detail.getIsbn() );
			System.out.print("\t" + detail.getUnitPrice() );
			System.out.print("\t" + detail.getQuantity() );
			BigDecimal price = detail.getUnitPrice().multiply(BigDecimal.valueOf(detail.getQuantity()));
			System.out.print("\t" + price  );
			System.out.println();
			sum.add(price) ;
		}
		System.out.println("总价格是：" + sum.toString());
	}

	private static Book selectBook(){
		for(;;){
			String isbn = Console.inputLine("请输入图书编号：");
			Book book = bookManager.fetchBook(isbn);
			if( book != null ) {
				return book;
			}
			System.out.println("图书编号不存在，请核对后再次输入。");
		}
	}

}
