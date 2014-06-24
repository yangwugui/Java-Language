package ruandao.classmember;

public class Return {

	public static void main(String[] args) {
		int number=7;
		
		System.out.println("要判断的数 " + number + ": ");
		if( isPrime(number) ){
			System.out.println("是质数。");
		}
		else{
			System.out.println("不是质数。");
		}
		
		prime(number);
			
	}

	private static boolean isPrime(int number) {
		for(int i=2; i<number; i++){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}

	private static void prime(int number){
		for(int i=2; i<number; i++){
			if(number % i == 0){
				System.out.println("不是质数。");
				return;
			}
		}
		System.out.println("是质数。");
	}
}
