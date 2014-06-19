package ruandao.utility;

public class TextArray {

	public static void main(String[] args) {
		String[] textList ;
		textList = new String[10];
		textList[0] = "aaaaa";
		textList[1] = "bbbbb";
		insertAt(textList, 1, "Insert 1 OK!");
		print(textList);
		insertAt(textList, -1, "Insert -1 OK!");
		print(textList);
		insertAt(textList, 8, "Insert 8 OK!");
		print(textList);
		insertAt(textList, 0, "Insert 0 OK!");
		print(textList);

		append(textList, "Append OK!");
		
		removeAt(textList,1);
		int pos = getIndex(textList, "bbbbb");
		System.out.println("remove at index OK!");
	}
	
	public static void print(String [] array){
		for(String s: array){
			if( s== null ) break;
			System.out.println(s);
		}
		System.out.println();
	}
	
	// 
	public static int getLastIndex(String[] array){
		for(int i=0; i<array.length; i++){
			if( array[i] == null ) return i;
		}
		return -1;
	}
	
	public static int getIndex(String[] array, String text){
		for(int i=0; i<array.length; i++){
			if( text.equals(array[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static String append(String[] array, String text){
		return insertAt(array, -1, text);
	}
	
	public static String removeAt(String[] array, int index){
		String error = "";
		if( index <0 || index > array.length-1) {
			error = "指定的位置是错误的。";
			return error;
		}
		for(int i = index; i<array.length - 1; i++){
			array[i] = array[i+1];
		}
		
		array[array.length - 1] = null;
		return error;
	}
	
	public static String remove(String[] array, String text){
		int index = getIndex(array, text);
		return removeAt(array,index);
	}
	
	public static String insertAt(String[] array, int position, String text){
		int lastIndex = getLastIndex(array);
		if( lastIndex == -1 ){
			return "货架已经满了，放不了东西啦！";
		}
		
		if( position < 0 || position > lastIndex ){
			position = lastIndex;
		}
		
		for(int i = lastIndex -1 ; i >= position; i--){
			array[i+1] = array[i];
		}
		array[position] = text;
		return "";
	}

}
