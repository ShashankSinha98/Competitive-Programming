import java.util.*;
import java.lang.*;
public class SEQ_Spoj {
	
	static int MOD = 1000000000;
	static int k;
 
	static long[] a, b, c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		 
		long  num;
		int n,t;
 
		// No of Test Cases...
		t = s.nextInt();
 
		while (t != 0) {
			t--;
 
			k = s.nextInt();
 
			// Input Array
			b = new long[k];
 
			for (int i = 0; i < k; i++) {
				b[i] = s.nextLong();
			}
 
			// Coefficients Array
			c = new long[k];
 
			for (int i = 0; i < k; i++) {
				c[i] = s.nextLong();
			}
 
			// Value of n
 
			n = s.nextInt();
 
			System.out.println(compute(n));
 
			b = new long[k];
			c = new long[k];
 
		}
 
	}
	
	static long compute(int n) {
		// Base Case
		if (n == 0)
			return 0;
 
		// For n<=k
		if (n <= k) {
			return b[n - 1];
		}
 
		// Otherwise we use Matrix Exponentiation
 
		long[] F1 = new long[k + 1];
 
		for (int i = 1; i <= k; i++) {
			F1[i] = b[i - 1];
		}
 
		// 2. Transformation Matrix Creation
		long[][] T = new long[k + 1][k + 1];
 
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= k; j++) {
				// Not Reached the Last Row
				if (i < k) {
					if (j == i + 1) {
						T[i][j] = 1;
 
					} else {
 
						T[i][j] = 0;
					}
 
					// continue;
				} else {
 
					// Last Row- Store coeff in reverse order
					T[i][j] = c[k - j];
				}
			}
		}
 
		// 3. T^n-1
		T = pow(T, n - 1);
 
		// 4. Multiply by F1
		long res = 0;
		for (int i = 1; i <= k; i++) {
			res = (res + (T[1][i] * F1[i]) % MOD) % MOD;
		}
 
		return res;
 
	}
 
	static long[][] pow(long[][] T, long p) {
		// Base Case
		if (p == 1)
			return T;
 
		// Recursive case
 
		if ((p & 1) == 1)
			return multiply(T, pow(T, p - 1));
 
		else {
 
			long[][] X = pow(T, p / 2);
			return multiply(X, X);
		}
	}
 
	// Multiply two matrices
	static long[][] multiply(long[][] A, long[][] B) {
		long[][] res = new long[k + 1][k + 1];
 
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= k; j++) {
				for (int x = 1; x <= k; x++) {
					res[i][j] = (res[i][j] + (A[i][x] * B[x][j]) % MOD) % MOD;
				}
			}
		}
 
		return res;
	}
} 