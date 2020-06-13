import java.util.*;
public class Subsums {
	
	static int MOD = 987654321;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		String[] strArr = str.split("\\s+");
		int n = Integer.valueOf(strArr[0]);
		long t =  Long.valueOf(strArr[1]);
		
		int[] F = new int[n];
		for(int i=0; i<n; i++) {
			F[i] = s.nextInt();
		}
		
		int[][] T = createTransformationMatrix(n);
		//display(T);
		
		int[][] T_upd = power(T,t);
		//display(T_upd);
		
		int[] res = new int[n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				res[i] = (res[i] + (T_upd[i][j] * F[j])%MOD)%MOD;
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(res[i]);
		}
		

	}
	
	static int[][] power(int[][] T, long t){
		
		if(t==1)
			return T;
		
		if((t&1)==1) {
			return multiply(T,power(T,t-1)); 
		} else {
			int[][] X = power(T,t/2);
			return multiply(X,X);
		}
		
	}
	
	static int[][] multiply(int[][] A, int[][] B){
		
		int n = A.length;
		int[][] res = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int x=0; x<n; x++) {
					res[i][j] = (res[i][j] + (A[i][x]*B[x][j])%MOD)%MOD;
				}
			}
		}
		
		return res;
	}
	
	public static void display(int[][] arr) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+"	");
			}
			System.out.println();
		}
	}
	
	static int[][] createTransformationMatrix(int n){
		
		int[][] T = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				if(i!=j)
					T[i][j] = 1;
			}
		}
		
		return T;
	}

}
