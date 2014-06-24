package ruandao.classmember;
import java.util.Scanner;


public class DrawShape {
	public static Scanner input; 

	public static void main(String[] args) {
		input = new Scanner(System.in);
		boolean isExit = false;
		do{
			System.out.println();
			System.out.println("1. ����ʵ��������");
			System.out.println("2. ���ƿ��������Ρ�");
			System.out.println("0. �˳���");
			System.out.println("������ѧ��ѡ����Ӧ�Ĳ�����");
			
			int menu = input.nextInt();
			int lines = 10;
			switch (menu){
			case 1:
				System.out.println("������������");
				lines = input.nextInt();
				drawTriangle(lines);
				break;
			case 2:
				System.out.println("������������");
				lines = input.nextInt();
				drawEmptyTriangle(lines);
				break;
			case 0:
				isExit = true;
				break;
			}

		}while( !isExit );
		System.out.println("ллʹ�ã�bye bye !");
	}
	
	public static void drawTriangle(int lines){
		char character = 'A';
		
		for(int i=0; i<lines; i++){
			for(int j=0; j<lines-i; j++){
				System.out.print(' ');
			}
			for(int j=0; j<2*i+1; j++){
				System.out.print(character);
			}
			System.out.println();
		}
	}

	public static void drawEmptyTriangle(int lines){
		
		char character = 'A';
		
		for(int i=0; i<lines; i++){
			for(int j=0; j<lines-i; j++){
				System.out.print(' ');
			}
			System.out.print(character);
			for(int j=0; j<2*i-1; j++){
				if(i==lines-1)
					System.out.print(character);
				else
					System.out.print(' ');
			}
			if(i>0) System.out.print(character);
			System.out.println();
		}
	}
}
