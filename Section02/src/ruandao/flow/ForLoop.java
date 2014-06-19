package ruandao.flow;

public class ForLoop {

	public static void main(String[] args) {
		/*
		 * int i = 0;
		while(i<3){
			System.out.println("1.Hello, Loop!");
			System.out.println("2.Hello, Loop!");
			i = i + 1;
		}
		*/
		/*
		for(int i=0; i<3; i=i+1){
			System.out.println("1.Hello, Loop!");
			System.out.println("2.Hello, Loop!");
		}
		*/
		// ¼ÆÊýÑ­»·
		int i=0;
		for(;;){
			System.out.println("1.Hello, Loop!");
			System.out.println("2.Hello, Loop!");
			i=i+1;
			if( i>=3 ) break;
		}
	}

}
