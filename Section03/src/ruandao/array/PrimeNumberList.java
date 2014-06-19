package ruandao.array;
import java.util.ArrayList;
import java.util.List;


public class PrimeNumberList {

	public static void main(String[] args) {
		int size = 100000000;
		boolean[] isPrime = new boolean[size+1];
		for(int i=1; i<=size; i++) isPrime[i] = true;
		
		List<Integer> primes = new ArrayList<Integer>();
		
		for(int i=2; i<size; ){
			primes.add(i);
			for(int j=2; i*j<=size; j++ ) isPrime[i*j] = false;
			do{
				i++;
				if( isPrime[i]==true) break; // 找到下一个素数。
			} while(i<size);
		}
		int count = 0;
		for(int i=0; i<primes.size(); i++){
			if(i>=50 && i<primes.size()-50) continue;
			System.out.print(" "+primes.get(i) );
			count++;
			if( count==10 ){
				System.out.println();
				count=0;
			}
		}
		System.out.println("\n总数：" + primes.size() );
	}

}
