package ruandao.junit;

public class Calculate {
	
	// 5! = 5 * 4 * 3 * 2 *1
	// 5! = 5 * 4!
	public int jiecheng(int x){
		if(x==0) return 1;
		
		return x + jiecheng(x-1);
	}

	public static void main(String[] args) {
		Calculate cal = new Calculate();
		int i = 3;
		if( cal.jiecheng(i) == 6) {
			System.out.println("jiecheng is tested: OK!");
		}
		else System.out.println("jiecheng is ERROR!");
		if( cal.jiecheng(0) == 1) {
			System.out.println("jiecheng is tested: OK!");
		}
		else System.out.println("jiecheng is ERROR!");
	}

}
