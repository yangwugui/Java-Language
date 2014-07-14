package ruandao.collection.library;

import ruandao.utility.Console;

public class Program {

	public static void main(String[] args) {
		String selected = Console.selectMenu(
				new String[]{"1. ����ʹ��HashMap�洢���ݵİ汾��",
							 "2. ����ʹ��ArayList�洢���ݵİ汾��"});
		
		BookManager bookManager = null;
		switch( selected){
		case "1":
			bookManager = new BookMapManager();
			break;
		case "2":
			bookManager = new BookListManager();
			break;
		}
		
		boolean isExit = false;
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
					bookManager.add(new Book(name));
					System.out.println("ͼ���Ѿ��ɹ���⡣");
					break;
				case "2":
					System.out.println( bookManager.list() );
					break;
				case "3":
					System.out.println("== ɾ��ͼ�� ==");
					name = Console.inputLine("������������");
					bookManager.remove(name);
					System.out.println("ͼ��������Ϣ�Ѿ����١�");
					break;
				case "4":
					System.out.println("== ����ͼ�� ==");
					name = Console.inputLine("������������");
					bookManager.borrow(name);
					System.out.println("����ͼ�飬���úá�");
					break;
				case "5":
					System.out.println("== �黹ͼ�� ==");
					name = Console.inputLine("������������");
					bookManager.guihuan(name);
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
			
		} // for(;;)

	}

}
