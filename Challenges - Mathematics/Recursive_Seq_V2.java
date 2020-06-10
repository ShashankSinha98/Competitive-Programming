// Accepted on SPOJ :D

import java.util.Scanner;

public class Recursive_Seq_V2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t--!=0) {
			
			int k = s.nextInt();
			
			long[] b = new long[k];
			
			for(int i=0;i<k;i++) {
				b[i] = s.nextLong();
			}
			
			long[] c = new long[k];
			for(int i=0;i<k;i++) {
				c[i] = s.nextLong();
			}
			
			long[] arr = new long[3];
			for(int i=0;i<3;i++) {
				arr[i] = s.nextLong();
			}
			
			long m = arr[0];
			long n = arr[1];
			long p = arr[2];
			
			
			
			
			
			
			// Getting Transformation Matrix
			long[][] T = new long[k+1][k+1];
			T = computeTransformationMatrix(c);
			//display(T);
			
			
			
			
			// New F1 array
			long[] F1 = new long[k+1];
			for(int i=0; i<k; i++) {
				F1[0] = (F1[0]+ b[i])%p;
			}
			
			for(int i=1; i<=k; i++) {
				F1[i] = b[i-1]%p;
			}
			
			//System.out.println();
			/*for(int i=0;i<F1.length; i++) {
				System.out.print(F1[i]+"	");
			}*/
			
			//System.out.println();
			///////////////////////////////////////////
			long sum_m = 0;
			if(m<=k+1) {
				
				for(int i=0; i<m-1; i++) {
					sum_m  = (sum_m + F1[i+1])%p;
				}
			
				
			} else {
			
			// Cal sum till m
			long[][] T_m = power(T,m-k-1,p); 
			//System.out.println("T_m");
			//display(T_m);
			//System.out.println();
			
			for(int i=0; i<=k; i++) {
				sum_m = (sum_m + (T_m[0][i]*F1[i])%p)%p;
			}
			
			}
			//System.out.println("Sum_m"+sum_m);
			///////////////////////////////////////////////////////
			
			long sum_n = 0;
			if(n<=k) {
				for(int i=0; i<n; i++) {
					sum_n  = (sum_n + F1[i+1])%p;
				}
			
			} else {
			// Cal sum till m
			long[][] T_n = power(T,n-k,p);
			//System.out.println("T_n");
			//display(T_n);
			//System.out.println();
			for(int i=0; i<=k; i++) {
				sum_n = (sum_n + (T_n[0][i]*F1[i])%p)%p;
			}
			//System.out.println("Sum_n"+sum_n);
			
			}
			long ans = (sum_n - sum_m)%p;
			
			if(ans<0) {
				ans += p;
			}
			
			System.out.println(ans);
			
			
		}

	}
	
   public static long[][] power(long[][] T,long n,long MOD){
		
		if(n==1)
			return T;
		
		if((n & 1)==1) {
			return multiply(T,power(T,n-1,MOD),MOD);
		} else {
			long[][]  X = power(T,n/2,MOD);
			return multiply(X,X,MOD);
		}
		
	}
	
	
	public static long[][] multiply(long[][] A, long[][] B, long MOD){
		
		int k = A.length;
		long[][] res = new long[k][k];
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<k; j++) {
				for(int x=0; x<k; x++) {
					res[i][j] = (res[i][j] + (A[i][x]*B[x][j]));
					
					if(res[i][j]>=MOD)
						res[i][j]%=MOD;
				}
			}
		}
		return res;
	}
	
	public static long[][] computeTransformationMatrix(long[] c) {
		int k = c.length;
		long[][] T = new long[k+1][k+1];
		
		T[0][0] = 1;
		
		for(int i=0; i<=k; i++) {
			for(int j=1; j<=k; j++) {
				
				if(i==0) {
				
					T[i][j] = c[k-j];
					
					
				}else if(i<k) {
					
					if(j==i+1) {
						T[i][j] = 1;
					} else {
						T[i][j] = 0;
					}
					
				} else {
					T[i][j] = c[k-j];
				}
			}
		}
		
		return T;
	}

	public static void display(long[][] arr) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+"	");
			}
			System.out.println();
		}
	}
}
