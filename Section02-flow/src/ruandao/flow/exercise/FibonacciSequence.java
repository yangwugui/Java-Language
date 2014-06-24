package ruandao.flow.exercise;

public class FibonacciSequence {

	public static void main(String[] args) {
		int one = 1;
		int two = 1;
		int sum = 2;
		
		System.out.print("Fibonacci Sequence is:\n 1 1");
		int counter = 2;
		for(counter=3; counter<=40; counter++ ){
			int third = one + two;
			one = two;
			two = third;
			sum += third;
			System.out.print(" " + third);
			if( counter%10 == 0 ) System.out.println();
		}
		double avg = sum / 40.0;
		System.out.println("\nsum is: " + sum + " avg is: " + avg);

		double golden = ((double)one) / two;
		System.out.println("golden scale is: " + golden );
	}

}
