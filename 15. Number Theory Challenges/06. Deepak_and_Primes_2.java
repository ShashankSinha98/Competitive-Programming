// Accepted on SPOJ :D

import java.util.*;
import java.lang.*;

public class Primes1_Segmented_Sieve {
	
	static int LIM = 100000;
	static ArrayList<Integer> primesList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int[] primes = new int[LIM];
		for(int i=1; i<LIM; i++)
			primes[i] = 1;
		
		primes[0] = primes[1] = 0;
		primes[2] = 1;
		
		primesList = new ArrayList<>();
		
		for(int i=4; i<LIM; i+=2) {
			primes[i] = 0;
		}
		
		for(int i=3; i*i<LIM; i+=2) {
			if(primes[i]==1) {
				for(long j=i*i; j<LIM; j+=i) {
					primes[(int)j] = 0;
				}
			}
		}
		
		for(int i=0; i<LIM; i++) {
			if(primes[i]==1)
				primesList.add(i);
		}
		
			//System.out.println(primesList.size());
		
		
		int t = s.nextInt();
		s.nextLine();
		while(t--!=0) {
			
			String str = s.nextLine();
			String[] strArr = str.split("\\s+");
			long m = Long.valueOf(strArr[0]);
			long n = Long.valueOf(strArr[1]);
			
			int subset_len = (int)(n-m);
			int[] shifted_primes = new int[subset_len+1];
			
			for(int i=0; i<shifted_primes.length; i++) {
				shifted_primes[i]=1;
			}
			
			for(int x : primesList) {
				
				if(x*x > n) {
					break;
				}
				
				long st = (((int)m)/x)*x;
				if(st<m) {
					st+=x;
				}
				

				
				if(x>=m && x<=n) {
					st = x*2;
				}
				
					for(long j=st; j<=n; j+=x) {
												
						shifted_primes[(int)(j-m)] = 0;
					}
				
				
			}
			
			//displayRawArr(shifted_primes);
			
			for(int i=0; i<shifted_primes.length; i++) {
				if(shifted_primes[i]==1 && i+m != 1) {
					System.out.println(i+m);
				}
			}
			
			System.out.println();
			
		}

	}
	
static void displayRawArr(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}


}
