// Accepted on Codeforces

import java.util.*;
public class Almost_Primes {
	
	static int LIM = 3001; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] prime_factors = new int[LIM];
		
		for(int i=2;i<LIM;i++) {
			if(prime_factors[i]==0) {
				for(int j=i*2; j<LIM; j+=i) {
					prime_factors[j]+=1;
				}
			}
		}
		
		int res=0;
		for(int i=0; i<=n;i++) {
			if(prime_factors[i]==2)
				res+=1;
		}
		
		System.out.println(res);
		
		//displayRawArr(prime_factors);
		
		

	}
	
static void displayRawArr(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}

}




