import java.util.*;
public class Number_Of_Divisors {
	
	static int LIM = 1000000 ;
	static int MOD = 1000000007; 

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
				
				for(long j=i*i; j<LIM; j+=2*i) {
					prime_sieve[(int)j] = 0;
				}
			}
		}
		
		int t = s.nextInt();
		
		while(t--!=0) {
			int n = s.nextInt();
			
			int[] arr = new int[n];
			
			for(int i=0;i<n; i++) {
				arr[i] = s.nextInt();
			}
			
			int[] div_count = new int[LIM];
			
			for(int i=0; i<n; i++) {
				
				for(int j=0; primes.get(j)*primes.get(j)<=arr[i]; j++) {
					
					if(arr[i]%primes.get(j)==0) {
						int cnt=0;
						while(arr[i]%primes.get(j)==0) {
							cnt+=1;
							arr[i]/=primes.get(j);
						}
						div_count[primes.get(j)] = (div_count[primes.get(j)] + cnt)%MOD;					
					}
				}
				if(arr[i] >1) {
					div_count[arr[i]] = (div_count[arr[i]] + 1) % MOD;
				}
			}
			
			//display(div_count);
			long res=1;
			for(int i=0;i<LIM; i++) {
				res = (res * (div_count[i]+1))%MOD;
			}
			
			System.out.println(res);
			
			
		}
		
		

	}
	
	static void display(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
