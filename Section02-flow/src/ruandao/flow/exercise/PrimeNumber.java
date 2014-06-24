package ruandao.flow.exercise;

public class PrimeNumber {

	public static void main(String[] args) {
		int number=17;
		
		System.out.println("要判断的数 " + number + ": ");
		boolean isPrime = true;
		for(int i=2; i<number; i++){
			if(number % i == 0){
				isPrime = false;
				System.out.println("不是质数。");
				break;
			}
		}
		if( isPrime ){
			System.out.println("是质数。");
		}
	}

}
