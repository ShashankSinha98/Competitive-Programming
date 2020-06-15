import java.util.*;
public class SEQ_Spoj_2020 {
	
	static long MOD = 1000000000;

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
			
			int n = s.nextInt();
			
			long[][] T = new long[k][k];
			
			if(n<=k) {
				System.out.println(b[n-1]);
				continue;
			}
			
			// Getting Transformation Matrix
			T = computeTransformationMatrix(c);
			//display(T);
			
			// Compute T^(n-1)
			T = power(T,n-k);
			
			/*long[] res_arr = new long[k];
			for(int i=0; i<k; i++) {
				long temp=0;
				for(int j=0; j<k; j++){
					temp = (temp + (T[i][j]*b[j])%MOD)%MOD;
				}
				res_arr[i] = temp;
			}
			
			display1D(res_arr);*/
			
			long res=0;
			
			for(int i=0; i<k; i++) {
				res = (res + (b[i]*T[k-1][i])%MOD)%MOD;
			}
			
			System.out.println(res);
			
			
			
		}
		
		
	}
	
	public static long[][] power(long[][] T,int n){
		
		if(n==1)
			return T;
		
		if((n & 1)==1) {
			return multiply(T,power(T,n-1));
		} else {
			long[][]  X = power(T,n/2);
			return multiply(X,X);
		}
		
	}
	
	
	public static long[][] multiply(long[][] A, long[][] B){
		
		int k = A.length;
		long[][] res = new long[k][k];
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<k; j++) {
				for(int x=0; x<k; x++) {
					res[i][j] = (res[i][j] + (A[i][x]*B[x][j])%MOD)%MOD;
				}
			}
		}
		return res;
	}
	
	public static void display1D(long[] arr) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+"	");
		}
		System.out.println();
	}
	
	public static void display2D(long[][] arr) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+"	");
			}
			System.out.println();
		}
	}
	
	public static long[][] computeTransformationMatrix(long[] c){
		
		int k = c.length;
		long[][] T = new long[k][k];
		
		for(int i=0;i<k;i++) {
			for(int j=0; j<k; j++) {
				
				if(i<k-1) {
					
					if(j==i+1) {
						T[i][j] = 1;
					}else {
						T[i][j] = 0;
					}
						
				} else {
					
					T[i][j] = c[k-j-1];
					
				}
			}
		}
		
		return T;
		
	}

}
