import java.util.*;
public class Large_Prime {
	
	static int LIM = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int[] primes = new int[LIM];
		for(int i=1; i<LIM; i++)
			primes[i] = 1;
		
		primes[0] = primes[1] = 0;
		primes[2] = 1;
		
		for(int i=4; i<LIM; i+=2) {
			primes[i] = 0;
		}
		
		for(int i=3; i*i<LIM; i+=2) {
			
			if(primes[i]==1) {
				for(int j=i*i; j<LIM; j+=i) {
					primes[j] = 0;
				}
			}
		}
		
		long n = s.nextLong();
		int res = -1;
		if(n<LIM) {
			int num = (int)n;
			if(primes[num]==1){
				res = 1;
			} else {
				res = 0;
			}
		} else {
			
			for(int i=2;i*i<n; i++) {
				if(n%i==0)
					System.out.println(i);
					res = 0;
					break;
			}
			
		}
		
		if(res == 1 || res == -1) {
			System.out.println("PRIME");
		} else {
			System.out.println("NOT PRIME");
		}

	}

}
