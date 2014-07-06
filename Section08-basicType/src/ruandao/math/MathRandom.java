package ruandao.math;

public class MathRandom {

	public static void main(String[] args) {
		for( int i=0; i<20; i++){
			double x = Math.random();
			int count = 9999 - 1111 + 1;
			int value = 1111 + (int) (x * count);
			System.out.println((i+1) + ". " + value);
		}

	}

}
