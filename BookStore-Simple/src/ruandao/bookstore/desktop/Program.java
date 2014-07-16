package ruandao.bookstore.desktop;

import java.math.BigDecimal;

import ruandao.bookstore.Account;
import ruandao.bookstore.Book;
import ruandao.bookstore.PurchasedItem;
import ruandao.bookstore.server.AccountManager;
import ruandao.bookstore.server.BookManager;
import ruandao.bookstore.server.PurchasedItemManager;
import ruandao.utility.Console;

//�ͻ�����
public class Program {
	static final int EXIT_PROGRAM = 0;
	static final int LOGIN_VIEW = 1;
	static final int ADMIN_VIEW = 2;
	static final int ORDER_VIEW = 3;
	
	static Account currentUser = null;
	
    static BookManager bookManager = null; 
    static AccountManager accountManager = null;
	
	// ���������������֮�����ת
	public static void main(String[] args) 
			throws Exception {
	    
		System.out.println("��ӭ���������꣡");
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
		String isbn;
		Book book;
		int number;
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
				isbn = Console.inputLine("������ͼ���ţ�");
				book = bookManager.fetchBook(isbn);
				if( book == null ){
					System.out.println("ͼ���Ų����ڣ����������롣");
					listBooks(bookManager.getAllBooks());
					break;
				}
				number = Console.inputInt("���������������");
				bookManager.addBook(isbn, number);
				break;
				
			case "2":
				isbn = Console.inputLine("������ͼ���ţ�");
				book = bookManager.fetchBook(isbn);
				if( book == null ){
					System.out.println("ͼ���Ų����ڣ����������롣");
					listBooks(bookManager.getAllBooks());
					break;
				}
				for(;;){
					number = Console.inputInt("���������������");
					if( book.getAmount() >= number ) break;
					showBook(book);
					System.out.println("�������㣬���������룺");
				}
				bookManager.removeBook(isbn, number);
				break;
				
			case "3":
				for(;;){
					isbn = Console.inputLine("������ͼ���ţ�");
					book = bookManager.fetchBook(isbn);
					if( book == null ) break;
					showBook(book);
					System.out.println("ͼ�����Ѿ����ڣ����������롣");
				}
				
				book = new Book();
				book.setISBN(isbn);
				book.setTitle(Console.inputLine("������ͼ��ı��⣺"));
				book.setAuthor(Console.inputLine("���������ߵ�������"));
				book.setPublisher(Console.inputLine("����������磺"));
				book.setReleaseDate(Console.inputDate("������������ڣ�"));
				book.setPrice(Console.inputDecimal("������۸�"));
				book.setCoverImage(Console.inputLine("���������ͼƬ�ļ�����"));
				book.setAmount(Console.inputInt("���������������"));
				book.setIntroduction(Console.inputLine("������ͼ������ݼ�飺"));

				bookManager.newBook(book);
				break;
				
			case "4":
				listBooks(bookManager.getAllBooks());
				break;
				
			case "5":
				isbn = Console.inputLine("������ͼ���ţ�");
				book = bookManager.fetchBook(isbn);
				if( book == null ){
					System.out.println("ͼ���Ų����ڡ�");
				}
				else {
					showBook(book);
				}
				break;
				
			case "6":
				String search = Console.inputLine("����Ҫ���ҵĹؼ��֣�");
				listBooks(bookManager.searchBooks( search));
				break;
				
			case "7":
				try {
					bookManager.writeToXmlFile();
				} catch (Exception e) {
					System.out.println("�����ڲ����������޷����浽�����ϣ���ʧ�˵�ǰ¼��Ŀ�����ݣ���Ҫ�������롣");;
				}
				currentUser = null;
				return LOGIN_VIEW;
				
			case "0":
				try {
					bookManager.writeToXmlFile();
				} catch (Exception e) {
					System.out.println("�����ڲ����������޷����浽�����ϣ���ʧ�˵�ǰ¼��Ŀ�����ݣ���Ҫ�������롣");;
					System.out.println("��ϸ������Ϣ�ǣ�" + e.getMessage());
				}
				return EXIT_PROGRAM;
			}
		}//for(;;)
	}

	public static void listBooks(Book[] bookList) {
		System.out.println("ͼ���б�");
		System.out.println("ISBN   \t����     \t����        \t����         \t������");

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
		System.out.println("ISBN   \t����      \t����        \t����         \t������");
		System.out.print(book.getISBN());
		System.out.print("\t" + book.getAmount());
		System.out.print("\t" + book.getTitle());
		System.out.print("\t" + book.getAuthor());
		System.out.print("\t" + book.getPublisher());
		System.out.println();
	}

	public static int showOrderView(){
		System.out.println("��������");
		
		PurchasedItemManager purchasedItemManager = new PurchasedItemManager();
		
		for(;;){
			showPurchasedItems(purchasedItemManager.getAllItems().values().toArray(new PurchasedItem[0]));
			String choise = Console.selectMenu(new String[]{
					"1. ѡ��һ��ͼ��",
					"2. �޸�ͼ������",
					"3. �ύ���ᵥ",
					"4. ע���������ص�¼����",
					"0. �˳�ϵͳ"});
			switch(choise){
			case "1":
				purchasedItemManager.select(selectBook());
				break;
				
			case "2":
				int number = Console.inputInt("�����빺���������",0,100);
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
		System.out.println("isbn  \t����    \t����     \t�۸�");
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
		System.out.println("�ܼ۸��ǣ�" + sum.toString());
	}

	private static Book selectBook(){
		for(;;){
			String isbn = Console.inputLine("������ͼ���ţ�");
			Book book = bookManager.fetchBook(isbn);
			if( book != null ) {
				return book;
			}
			System.out.println("ͼ���Ų����ڣ���˶Ժ��ٴ����롣");
		}
	}

}
