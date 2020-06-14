// Accepted on hacker rank
// @link- https://www.hackerrank.com/contests/launchpad-1-winter-challenge/challenges/prime-visits/

import java.util.*;
public class Prime_Visits {
	
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
		
		int[] cumm_sum = new int[LIM];
		int count = 0;
		for(int i=0; i<LIM; i++) {
			count += primes[i];
			cumm_sum[i] = count;
		}
		
		//Display.displayRawArr(cumm_sum);
		int n = s.nextInt();
		s.nextLine();
		while(n--!=0) {
			
			String str = s.nextLine();
			String[] strArr = str.split("\\s+");
			int a = Integer.valueOf(strArr[0]);
			int b = Integer.valueOf(strArr[1]);
			
			System.out.println(cumm_sum[b] - cumm_sum[a-1]);
		}

	}

}

class Display{
	
	static void displayRawArr(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
}


