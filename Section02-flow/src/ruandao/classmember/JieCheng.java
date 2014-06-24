package ruandao.classmember;

public class JieCheng {

	public static void main(String[] args) {
		int number = InputUtility.inputInteger();
		System.out.println("½×³Ë" + number + "! = " + jieCheng1(number));
		System.out.println("½×³Ë" + number + "! = " + jieCheng2(number));
	}

	public static int jieCheng1(int number){
		int result = 1;
		for(int i=1; i<=number; i++){
			result *= i;
		}
		return result;
	}
	
	public static int jieCheng2(int number){
		if( number <= 1 ) return 1;
		return number * jieCheng2(number-1);
	}
}
