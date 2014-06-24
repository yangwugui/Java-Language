package ruandao.utility;

import java.util.Scanner;

public class Console {
	public static int inputInt(String prompt){
		System.out.println(prompt);
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
}
