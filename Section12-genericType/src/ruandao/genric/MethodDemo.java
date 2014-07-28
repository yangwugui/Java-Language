package ruandao.genric;

public class MethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intarray = new Integer[]{1,2,3,4,5};
		String[] strarray = {"aaaa","bbbb","cccc"};
		
		String s = getIndex(strarray, 2);
		
		Integer i = getIndex(intarray, 3);
	}

	public static <T>  T getIndex( T[] array, int index) {
		return array[index];
	}
	
}
