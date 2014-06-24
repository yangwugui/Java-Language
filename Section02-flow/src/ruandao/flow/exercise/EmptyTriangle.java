package ruandao.flow.exercise;

public class EmptyTriangle {

	public static void main(String[] args) {
		char character = 'A';
		int lines = 10;
		
		for(int i=0; i<lines; i++){
			for(int j=0; j<lines-i; j++){
				System.out.print(' ');
			}
			System.out.print(character);
			for(int j=0; j<2*i-1; j++){
				if(i==lines-1)
					System.out.print(character);
				else
					System.out.print(' ');
			}
			if(i>0) System.out.print(character);
			System.out.println();
		}
	}

}
