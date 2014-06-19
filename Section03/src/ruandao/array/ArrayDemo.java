package ruandao.array;

public class ArrayDemo {

	public static void main(String[] args) {
		intArrayStatistic();
		// 类型[] 变量名;
		String[] nameArray;
		//nameArray = new String[]{"aaa","bbb","ccc","ddd","eee"};
		nameArray = new String[5];
		// nameArray[0]: null
		nameArray[0] = "aaa";
		nameArray[1] = "bbb";
		nameArray[2] = "ccc";
		nameArray[3] = "ddd";
		nameArray[4] = "eee";
		
		int[] intArray = new int[20];
		
		for( int i=0; i<20; i++){
			intArray[i] = 0;
		}
		
		nameArray[0] = "zhang san";
		
		String name = nameArray[0];
		
		String[] another = {"1111","222","333"};
		for( int i=0; i<another.length; i++ ){
			System.out.println(another[i]);
		}
		//String s; in, 枚举集合元素， for in语法，foreach
		for( String s : another){
			System.out.println(s);
		}
		
		String[][] books = {new String[2],new String[3]};
		books[0] = new String[]{"aaaa","bbbb"};
		books[1] = new String[]{"111","222","333"};
		
		String str = books[1][2]; // 333
		books[1][2] = "abcdefg";
	}
	
	public static void intArrayStatistic(){
		int[] numbers = {34,56,12,3,57,7,9,234};
		int min = numbers[0];
		int max = numbers[0];
		int sum = 0;
		int avg;
		for( int x : numbers){
			sum += x;
			if( x<min ) min = x;
			if( x>max ) max = x;
		}
		avg = sum/numbers.length;
		System.out.println(
				"min:" + min +
				"max:" + max +
				"sum:" + sum +
				"avg:" + avg );
	}
	
	

}
