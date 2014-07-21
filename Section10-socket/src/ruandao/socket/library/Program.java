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
			
			String[] menu = {"1. ������",
					"2. �鿴��",
					"3. ɾ����",
					"4. �����",
					"5. �黹��",
					"6. ���档",
					"7. �򿪡�",
					"0. �˳���" };
			String select = Console.selectMenu(menu);
			try{
				switch(select){
				case "1":
					System.out.println("== ����ͼ�� ==");
					name = Console.inputLine("������������");
					bookManager.add(new Book(name));
					System.out.println("ͼ���Ѿ��ɹ���⡣");
					break;
				case "2":
					showBooks();
					break;
				case "3":
					System.out.println("== ɾ��ͼ�� ==");
					name = Console.inputLine("������������");
					bookManager.remove(name);
					System.out.println("ͼ��������Ϣ�Ѿ����١�");
					break;
				case "4":
					System.out.println("== ����ͼ�� ==");
					person = Console.inputLine("�������������֣�");
					name = Console.inputLine("������������");
					bookManager.borrow(person, name);
					System.out.println("����ͼ�飬���úá�");
					break;
				case "5":
					System.out.println("== �黹ͼ�� ==");
					person = Console.inputLine("������������֣�");
					name = Console.inputLine("������������");
					int days = bookManager.guihuan(person,name);
					System.out.println("��һ������" + days + "�죬�����" + days + "Ԫ��");
					System.out.println("лл����ӭ�´��������顣");
					break;
				case "6":
					System.out.println("== ����ͼ�� ==");
					String filename = Console.inputLine("�������ļ���·������");
					bookManager.save(filename);
					System.out.println("�Ѿ��ɹ����档");
					break;
				case "7":
					System.out.println("== ��ͼ�� ==");
					String openFile = Console.inputLine("�������ļ���·������");
					bookManager.open(openFile);
					System.out.println("�Ѿ��ɹ��򿪡�");
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
