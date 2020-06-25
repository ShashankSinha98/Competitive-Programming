import java.util.*;
public class Deepak_and_Primes {

	static int LIM=10000000;
	static int PRIME_LIM = 500000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int[] prime_sieve = new int[LIM];
		for(int i=0; i<LIM; i++) {
			prime_sieve[i] = 1;
		}
		
		prime_sieve[0] = prime_sieve[1] = 0;
		for(int i=4; i<LIM; i+=2) {
			prime_sieve[i] = 0;
		}
		
		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(2);
		for(long i=3;i<LIM; i+=2) {
			if(prime_sieve[(int)i]==1) {
				primes.add((int)i);
				
				if(primes.size()==PRIME_LIM)
					break;
				for(long j=i*i; j<LIM; j+=2*i) {
					prime_sieve[(int)j] = 0;
				}
			}
		}
		int n = s.nextInt();

		System.out.println(primes.get(n-1));
		
		

	}

}
