package ruandao.classmember;

public class Return {

	public static void main(String[] args) {
		int number=7;
		
		System.out.println("Ҫ�жϵ��� " + number + ": ");
		if( isPrime(number) ){
			System.out.println("��������");
		}
		else{
			System.out.println("����������");
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
				System.out.println("����������");
				return;
			}
		}
		System.out.println("��������");
	}
}
