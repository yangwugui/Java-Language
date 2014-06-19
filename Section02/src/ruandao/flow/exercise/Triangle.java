package ruandao.flow.exercise;

public class Triangle {

	public static void main(String[] args) {
		char character = 'A';
		int lines = 10;
		
		for(int i=0; i<lines; i++){
			for(int j=0; j<lines-i; j++){
				System.out.print(' ');
			}
			for(int j=0; j<2*i+1; j++){
				System.out.print(character);
			}
			System.out.println();
		}
	}

}
