package ruandao.classmember;
import java.util.Scanner;


public class ReturnValue {

	public static void main(String[] args) {
		System.out.println("������Բ�İ뾶��");
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		double mianji = calculateCircleArea(r);
		System.out.println("����ǣ�" + mianji);
	}

	public static double calculateCircleArea(int radium ){
		double PI = 3.14159265;
		double area = PI * radium * radium;
		return area;
	}
}
