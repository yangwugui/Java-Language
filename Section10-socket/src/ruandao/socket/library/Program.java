package ruandao.socket.library;

import ruandao.utility.Console;

public class Program {

	static BookClient bookClient = null;
	
	public static void main(String[] args) {
		bookClient = new BookClient();
		
		boolean isExit = false;
		String person = "";
		String name = "";
		for(;;){
			
			String[] menu = {"1. ������",
					"2. �鿴��",
					"3. ɾ����",
					"4. �����",
					"5. �黹��",
					"0. �˳���" };
			String select = Console.selectMenu(menu);
			try{
				switch(select){
				case "1":
					System.out.println("== ����ͼ�� ==");
					name = Console.inputLine("������������");
					bookClient.add(new Book(name));
					System.out.println("ͼ���Ѿ��ɹ���⡣");
					break;
				case "2":
					showBooks();
					break;
				case "3":
					System.out.println("== ɾ��ͼ�� ==");
					name = Console.inputLine("������������");
					bookClient.remove(name);
					System.out.println("ͼ��������Ϣ�Ѿ����١�");
					break;
				case "4":
					System.out.println("== ����ͼ�� ==");
					person = Console.inputLine("�������������֣�");
					name = Console.inputLine("������������");
					bookClient.borrow(person, name);
					System.out.println("����ͼ�飬���úá�");
					break;
				case "5":
					System.out.println("== �黹ͼ�� ==");
					person = Console.inputLine("������������֣�");
					name = Console.inputLine("������������");
					int days = bookClient.guihuan(person,name);
					System.out.println("��һ������" + days + "�죬�����" + days + "Ԫ��");
					System.out.println("лл����ӭ�´��������顣");
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
	
	public static void showBooks() throws Exception {
		int i = 1;
		for(Book book : bookClient.getAllBooks()){
			System.out.println( i + ". " + book  + "\n" );
			i++;
		}
	}

}
