package ruandao.adt;

public class UseRectangle {

	public static void main(String[] args) {
		Rectangle rect;
//		rect = new Rectangle();
//		rect.length = 40;
//		rect.width = 30;
		
		rect = new Rectangle(40,30);
		
		Rectangle rect2 = new Rectangle();
		
		int area = 0;
		area = rect.length * rect.width;
		
		System.out.println("Area is: " + area);
		
		System.out.println("Area is: " + (rect.length*rect.width) );
	}

}
