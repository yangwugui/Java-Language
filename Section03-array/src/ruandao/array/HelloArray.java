package ruandao.array;

public class HelloArray {

	public static void main(String[] args) {
		// ���顢 ���ȡ�Ԫ�ء��������±꣩
		int[] array;
		
		// ������ֵ��������ԣ�new ����˼�Ƿ���������ЩԪ�صĿռ䡣
		array = new int[100];  // ����ĳ���
		// ����0�����飬 base 0
		if(array[8]==234){
			
		}

		// ͬ��
		// �칹
		
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
		// ���ϵ�ö�����
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
