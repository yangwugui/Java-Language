package ruandao.array;
import java.util.Scanner;


public class DataCollection {

	public static void main(String[] args) {
		int[] scores = new int[10]; // 长度,个数， size
		
		int[] intArray1 = new int[]{1,2,3,4,5};
		int[] intArray2 = {1,2,3,4,5};
		String[] strArray1 = new String[] {"aaaa","bbbb"};
		String[] strArray2 = {"aaaa","bbbb"};
		String[] strArray;
	
		Scanner scanner = new Scanner(System.in);
		int index = 0;
		while(index<5){
			System.out.println("请输入一个数：");
			scores[index] = scanner.nextInt();
			index = index + 1;
		}
		
		System.out.print("刚刚输入的数是：");
		for( int i=0; i<5; i++){
			System.out.print(scores[i] );
			if( i<4 ) System.out.print (",");
		}
		System.out.println();
	
		System.out.print("刚刚输入的数是：");
		for( int i=0; i<5; i++){
			if( i>0 ) System.out.print (",");
			System.out.print(scores[i] );
		}
		System.out.println();
	 
		System.out.print("刚刚输入的数是：");
		boolean first = true;
		for( int score : scores){  // for each, for in
			if( !first ){
				System.out.print (",");
			}
			System.out.print(score);
			first = false;
		}
		System.out.println();

	}

}
