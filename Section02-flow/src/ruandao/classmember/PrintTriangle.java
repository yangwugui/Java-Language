package ruandao.classmember;
import java.util.Scanner;


public class PrintTriangle {

	public static void main(String[] args) {
		System.out.println("输入三角形的行数：");
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		printTriangle(count);
	}

	private static void printTriangle(int lines) {
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

}
