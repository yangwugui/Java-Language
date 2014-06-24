package ruandao.array;

public class HelloArray {

	public static void main(String[] args) {
		// 数组、 长度、元素、索引（下标）
		int[] array;
		
		// 对于数值型数组而言，new 的意思是分配容纳这些元素的空间。
		array = new int[100];  // 数组的长度
		// 基于0的数组， base 0
		if(array[8]==234){
			
		}

		// 同构
		// 异构
		
		//int[] numbers = {1,34,78,98,100,45,43,88,22};
		int[] numbers = new int[]{1,34,78,98,100,45,43,88,22};
		
		//String[] strings = {"aaa","bbb","ccc","1111","6666","fffff"};
		String[] strings = new String[]{"aaa","bbb","ccc","1111","6666","fffff"};
		
		for(int i=0; i<6; i++){
			System.out.println(strings[i]);
		}
		
		for(int i=0; i<strings.length/*6*/; i++){
			System.out.println(strings[i]);
		}
		
		// for in
		// for each
		// 集合的枚举语句
		// for s in strings
		
		for(String s : strings){
			System.out.println(s);
		}
		
		int[][] arrayNumbers = {
					{44,33,2,8},
					{3,5},
					{7,8,9,23,45,21,34,54,99}
				};
/*
{
	{44,33,2,8},
	{3,5},
	{7,8,9,23,45,21,34,54,99}
};
*/
		System.out.println("{");
		for(int[] intArray : arrayNumbers){
			System.out.print("\t{");
			boolean isFirst = true;
			for( int number : intArray){
				if(isFirst){
					isFirst = false;
				}
				else{
					System.out.print(",");
				}
				System.out.print(number);
			}
			System.out.println("},");
		}
		System.out.println("};");
	}

}
