import java.util.Scanner;

public class FIBOSUM {
	
	static long MOD = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		s.nextLine();
		
		while(t--!=0) {
			
			String str = s.nextLine();
			String[] arr = str.split("\\s+");
			long n = Long.valueOf(arr[0]);
			long m = Long.valueOf(arr[1]);
			
			
			
			long[] b = {0,1};
			long[] c = {1,1};
			int k=2;
			
			long x = 0;
			long y = 0;
			
			
				long[][] T = {{0,1},{1,1}};
				
				T = power(T,m+2,MOD);
								
				for(int i=0; i<k; i++) {
					x = (x + (b[i]*T[0][i])%MOD)%MOD;
				}
				
				//System.out.println(x);
			
			
				long[][] T1 = {{0,1},{1,1}};
				
				T1 = power(T1,n+1,MOD);
				
				
				for(int i=0; i<k; i++) {
					y = (y + (b[i]*T1[0][i])%MOD)%MOD;
				}
				
				//System.out.println(y);
			
				
				System.out.println(((x-y+MOD)%MOD));
			
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
	
	

}
