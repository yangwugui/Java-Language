package ruandao.flow.exercise;

public class PrimeNumber {

	public static void main(String[] args) {
		int number=17;
		
		System.out.println("Ҫ�жϵ��� " + number + ": ");
		boolean isPrime = true;
		for(int i=2; i<number; i++){
			if(number % i == 0){
				isPrime = false;
				System.out.println("����������");
				break;
			}
		}
		if( isPrime ){
			System.out.println("��������");
		}
	}

}
