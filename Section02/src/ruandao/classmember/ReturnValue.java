package ruandao.classmember;
import java.util.Scanner;


public class ReturnValue {

	public static void main(String[] args) {
		System.out.println("请输入圆的半径：");
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		double mianji = calculateCircleArea(r);
		System.out.println("面积是：" + mianji);
	}

	public static double calculateCircleArea(int radium ){
		double PI = 3.14159265;
		double area = PI * radium * radium;
		return area;
	}
}
