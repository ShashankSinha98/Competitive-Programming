import java.util.*;
public class Bitset_Sieve {
	
	static int lim = 100;
	static ArrayList<Integer> primes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BitSet b = new BitSet(lim+1);
		primes = new ArrayList<>();
		
		for(int i=0; i<=lim; i++) {
			b.set(i);
		}
		b.clear(0);
		b.clear(1);
		
		for(int i=2; i*i<=lim; i++) {
			
			if(b.get(i)) {
				for(int j=2*i; j<=lim; j+=i) {
					b.clear(j);
				}
			}
		}
		
		for(int i=0; i<=lim; i++) {
			if(b.get(i))
				primes.add(i);
		}
		
		System.out.println(primes);
		
		

	}

}
