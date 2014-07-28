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
	
	// ���������������֮�����ת
	public static void main(String[] args) 
			throws Exception {
	    
		System.out.println("��ӭ���������꣡");
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
		System.out.println("лл���٣���ӭ�´����������꣡");
	}
	
	public static int showLoginView(){
		String choise = Console.selectMenu(new String[]{"1. ��¼","0. �˳�ϵͳ"});
		if( choise.equals("0") ){
			return EXIT_PROGRAM;
		}
		for(;;){
			String name = Console.inputString("�û����ƣ�");
			String password = Console.inputString("�û����룺");
			try{
				currentUser = accountManager.login(name, password);
			}
			catch(Exception exc){
				System.out.println(exc.getMessage());
				boolean exit = Console.confirm("��¼ʧ�ܣ����� y �˳�ϵͳ�����س�������", 'y');
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
		System.out.println("ͼ�������");
		for(;;){
			String choise = Console.selectMenu(new String[]{
					"1. ͼ�����",
					"2. ͼ�����",
					"3. ����ͼ��",
					"4. �鿴ȫ����ͼ��",
					"5. ����ָ��ISBN��ͼ��",
					"6. ���ݷ��ࡢ���������ߺͳ��������Ϣ����ͼ��",
					"7. ע���������ص�¼����",
					"0. �˳�ϵͳ"});
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
		System.out.println("ͼ���б�");
		System.out.println("ISBN  \t����        \t����         \t������\n");

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
		System.out.println("ͼ�������");
		for(;;){
			String choise = Console.selectMenu(new String[]{
					"1. ѡ��һ��ͼ��",
					"2. �޸�ͼ������",
					"3. �ύ���ᵥ",
					"4. ע���������ص�¼����",
					"0. �˳�ϵͳ"});
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
