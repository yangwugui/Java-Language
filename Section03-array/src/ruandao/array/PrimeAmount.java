package ruandao.array;
import java.util.ArrayList;
import java.util.List;


public class PrimeAmount {

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
		int prevCount = 0;
		int count = 0;
		int min = 2;
		int max = 3;
		int bit = 2;
		for(int i=0; i<primes.size(); i++){
			if( primes.get(i) >= min*2 ){
				System.out.print(", prev/curr: " + prevCount/(double)count);
				System.out.print(", count/range: " + count/(double)min);
				System.out.println(", 位数" + bit + "[" + min + "," + max + "]中的质数个数：" + count);
				min = min*2;
				max = min*2 - 1;
				bit ++;
				prevCount = count;
				count=0;
			}
			count++;
		}
		System.out.println("\n总数：" + primes.size() );
		System.out.println("count/total range: " + primes.size()/100000000.0 );
	}

}
