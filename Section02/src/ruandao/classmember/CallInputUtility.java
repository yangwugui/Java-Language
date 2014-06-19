package ruandao.classmember;
import java.util.Scanner;


public class CallInputUtility {

	public static void main(String[] args) {
		int number = InputUtility.inputInteger();
		int sum=0;
		for(int i=0; i<=number; i++){
			sum += i;
		}
		System.out.println("从0加到" + number + "的总和是：" + sum);
	}
}
