package ruandao.adt;

public class Rectangle {
	public int length;
	public int width;
	
	// 默认构造：没有参数的构造方法。
	public Rectangle(){
		length = 0;
		width = 0;
	}
	
	public Rectangle(int length, int width){
		this.length = length;
		this.width = width;
	}
}
