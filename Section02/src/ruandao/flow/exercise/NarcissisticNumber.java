package ruandao.flow.exercise;

public class NarcissisticNumber {

	public static void main(String[] args) {
		int counter=0;
		for(int i=1; i<10; i++){
			for( int j=0; j<10; j++){
				for(int k=0; k<10; k++){
					if( 100*i + 10*j + k == i*i*i + j*j*j + k*k*k){
						counter ++;
						System.out.println("第" + counter + "个水仙花数是："+ i + j + k);
					}
				}
			}
		}

	}

}
