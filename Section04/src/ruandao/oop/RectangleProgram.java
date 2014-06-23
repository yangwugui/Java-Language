package ruandao.oop;

public class RectangleProgram {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(50,30);
		// obj.method(arg1, arg2,...)  =>  function(obj, arg1, arg2,...)
		
		int area = rect.calculateArea();  // rect.length * rect.width;
		//int area = Rectangle.calculateArea();
		//int area2 = staticCalculateArea(rect);
		
		// toString: ������ �����������Ƕ���Ŀɶ�����ʾ��
		System.out.println( rect + " Area is: " + area);
		System.out.println( rect.toString() + " Area is: " + area);
	}
	
//	static int staticCalculateArea(Rectangle rect){
//		return rect.length * rect.width;
//	}

}
