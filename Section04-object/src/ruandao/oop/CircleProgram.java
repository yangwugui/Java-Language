package ruandao.oop;

import java.util.Scanner;

public class CircleProgram {

	public static void main(String[] args) {
		Circle c = new Circle();

		Scanner input = new Scanner(System.in);
		double r = input.nextDouble();
		c.setRadius(r);
		
		System.out.println("�뾶Ϊ" + c.getRadius() + "��Բ������ǣ�" + c.getArea());
	}

}
