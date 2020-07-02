import java.util.*;
public class Tiling_Problem_2 {
	
	static long MOD =1000000007;
	static int LIM = 100000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t != 0)
		{
			t--;
		

			int n = s.nextInt();
			int m = s.nextInt();
			long[] sieve = new long[LIM+1];
			
			System.out.println(fn2(n,m,sieve)%MOD);
			
		}

	}
	
	static long fn2(int n, int m,long[] sieve)
	{
		if(n < m)
			return 1;
		
		if(n == m)
			return 2;

	
		for(int i=0; i<=LIM;i++) {
			if (i<m) {
				sieve[i] = 1;
			} else if(i==m) {
				sieve[i] = 2;
			} else {
				sieve[i] = (sieve[i-1] + sieve[i-m])%MOD;
			}
			
		}
		
		
		return sieve[n];

	}

}
