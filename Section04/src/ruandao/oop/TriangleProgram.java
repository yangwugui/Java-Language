package ruandao.oop;

public class TriangleProgram {

	public static void main(String[] args) {
		new Triangle("A", 5, true).print();
		
		Triangle t = new Triangle("A", 5, false);
		t.print();
	}

}
