package ruandao.bookstore.client;

import java.io.*;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ruandao.bookstore.*;
import ruandao.bookstore.server.AccountManager;
import ruandao.bookstore.server.BookManager;
import ruandao.bookstore.server.PurchasedItemManager;
import ruandao.utility.Console;

public class Program {
	static final int EXIT_PROGRAM = 0;
	static final int LOGIN_VIEW = 1;
	static final int ADMIN_VIEW = 2;
	static final int ORDER_VIEW = 3;
	
	static Account currentUser = null;
	
    static BookManager bookManager = null; 
    static AccountManager accountManager = null;
    static PurchasedItemManager orderManager = null;
	
	// 控制器，负责界面之间的跳转
	public static void main(String[] args) 
			throws Exception {
	    
		System.out.println("欢迎光临软道书店！");
		bookManager = new BookManager("D:/Course/Java Language/Source Workspace/BookStore/Book Files/");
		accountManager = new AccountManager("D:/Course/Java Language/Source Workspace/BookStore/Book Files/");
		
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
				break;
				
			case "2":
				break;
				
			case "3":
				break;
				
			case "4":
				break;
				
			case "5":
				break;
				
			case "6":
				break;
				
			case "7":
				currentUser = null;
				return LOGIN_VIEW;
				
			case "0":
				return EXIT_PROGRAM;
			}
		}//for(;;)
	}

	public static void listBooks(Book[] bookList) 
			throws UnknownHostException, FileNotFoundException, IOException, ClassNotFoundException
	{
		System.out.println("图书列表");
		System.out.println("ISBN  \t书名        \t作者         \t出版社\n");

		for(  Book book : bookList){
			System.out.print(book.getISBN());
			System.out.print("\t" + book.getTitle());
			System.out.print("\t" + book.getAuthor());
			System.out.print("\t" + book.getPublisher());
			System.out.println();
		}
	}

	public static void showBook(Book book) 
			throws UnknownHostException, FileNotFoundException, IOException, ClassNotFoundException{
	
	}

	public static int showOrderView(){
		System.out.println("图书库存管理");
		for(;;){
			String choise = Console.selectMenu(new String[]{
					"1. 选择一本图书",
					"2. 修改图书数量",
					"3. 提交的提单",
					"4. 注销，并返回登录界面",
					"0. 退出系统"});
			switch(choise){
			case "1":
				break;
				
			case "2":
				break;
				
			case "3":
				return ORDER_VIEW;
				
			case "4":
				currentUser = null;
				return LOGIN_VIEW;
				
			case "0":
				return EXIT_PROGRAM;
			}
		}//for(;;)
	}

}
