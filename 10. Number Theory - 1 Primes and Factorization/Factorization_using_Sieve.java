import java.util.*;
public class Factorization_using_Sieve {

	static int LIM = 10000000;
	
	static ArrayList<Integer> primeList;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int[] primes = new int[LIM];
		primes[2] = 1;
		for(int i=3; i<LIM; i+=2)
			primes[i] = 1;
		
		for(int i=3; i*i<LIM; i++) {
			if(primes[i]==1) {
				for(long j=i*i; j<LIM; j+=i) {
					primes[(int)j]=0;
				}
			}
		}
		
		primeList = new ArrayList<>();
		for(int i=0; i<LIM; i++) {
			if(primes[i]==1)
				primeList.add(i);
		}
		
		//displayRawArr(primes);
		//System.out.println(primeList);
		
		int n = s.nextInt();
		ArrayList<Integer> factors = new ArrayList<>();
		
		for(int i=0; primeList.get(i)*primeList.get(i)<=n; i++) {
			
			if(n % primeList.get(i)==0) {
				while(n%primeList.get(i)==0) {
					factors.add(primeList.get(i));
					n /= primeList.get(i);
				}
			}
		}
		
		if(n>1) {
			factors.add(n);
		}
		
		System.out.println(factors);
		
		
		

	}
	
	static void displayRawArr(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}

}
