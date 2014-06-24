package ruandao.array;
import java.util.Arrays;


public class SortArray {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		System.out.println("排序前：");
		print(array);
		
		sortUp(array);
		System.out.println("\n排序后：");
		print(array);
		
		sortDown(array);
		System.out.println("\n排序后：");
		print(array);
		
		Arrays.sort(array);
		System.out.println("\n用 Arrays.sort 排序后：");
		print(array);
		
	}



	private static void print(int[] array) {
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
	
	
	
	public static void sortUp(int[] array){
		for(int i=0; i<array.length-2; i++){
			for(int j=array.length-1; j>i; j--){
				// array[j-1]前
				// array[j]  后
				if( array[j] < array[j-1] ){
					int tmp = array[j-1];
					array[j-1] = array[j];
					array[j] = tmp;
				}
			} // inner for
		} // out for
		
		/*		int a = 10;
		int b = 20;
		
		int tmp;
		tmp = a;
		a = b;
		b = tmp;*/	}
	
	public static void sortDown(int[] array){
		for(int i=array.length-1; i>0; i--){
			boolean isOk = true;
			for(int j=0; j<i; j++){
				if( array[j] > array[j+1] ){
					int tmp = array[j+1];
					array[j+1] = array[j];
					array[j] = tmp;
					isOk = false;
				}
			} // inner for
			if( isOk ) break;
		} // outer for

	}

}
