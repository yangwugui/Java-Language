package ruandao.oop;

public class Circle {
	static final double PI = 3.14159265;
	private double radius = 0.0;
	
	public double getRadius(){
		return this.radius;
	}
	
	public void setRadius(double r){
		if( r<0.0){
			System.out.println("圆的半径不能为负数。");
		}
		else this.radius = r;
	}
	
	public double getArea(){

		return PI * radius * radius;
	}
}
