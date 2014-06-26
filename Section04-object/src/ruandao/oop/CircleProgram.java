package ruandao.oop;

import java.util.Scanner;

public class CircleProgram {

	public static void main(String[] args) {
		Circle c = new Circle();

		Scanner input = new Scanner(System.in);
		double r = input.nextDouble();
		c.setRadius(r);
		
		System.out.println("半径为" + c.getRadius() + "的圆的面积是：" + c.getArea());
	}

}
