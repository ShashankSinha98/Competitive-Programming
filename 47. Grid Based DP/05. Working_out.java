// AC on Codeforces
import java.util.*;
public class Working_out {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		String[] strarr = str.split("\\s+");
		int n = Integer.valueOf(strarr[0]);
		int m = Integer.valueOf(strarr[1]);
		
		int[][] arr = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		System.out.println(new Working_out().solve(arr, n, m));
		
		
	}
	
	private int solve(int[][] arr, int n, int m) {
		
		int[][] dp1 = new int[n+2][m+2];
		int[][] dp2 = new int[n+2][m+2];
		int[][] dp3 = new int[n+2][m+2];
		int[][] dp4 = new int[n+2][m+2];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp1[i][j] = Math.max(dp1[i-1][j],dp1[i][j-1])+arr[i][j];
			}
		}
		//display(dp1);
		for(int i=n; i>=1; i--) {
			for(int j=1; j<=m; j++) {
				dp2[i][j] = Math.max(dp2[i+1][j],dp2[i][j-1])+arr[i][j];
			}
		}
		//display(dp2);
		for(int i=1; i<=n; i++) {
			for(int j=m; j>=1; j--) {
				dp3[i][j] = Math.max(dp3[i-1][j],dp3[i][j+1])+arr[i][j];
			}
		}
		//display(dp3);
		for(int i=n; i>=1; i--) {
			for(int j=m; j>=1; j--) {
				dp4[i][j] = Math.max(dp4[i+1][j],dp4[i][j+1])+arr[i][j];
			}
		}
		//display(dp4);
		int res = Integer.MIN_VALUE;
		for(int i=2;i<n;i++) {
			for(int j=2;j<m;j++) {
				int r1 = dp1[i-1][j]+dp2[i][j-1]+dp3[i][j+1]+dp4[i+1][j];
				int r2 = dp1[i][j-1]+dp2[i+1][j]+dp3[i-1][j]+dp4[i][j+1];
				res = Math.max(res, Math.max(r1, r2));
			}
		}
	
		
		return res;
	}
	
	
	
	
	
	
	
	
	static void display(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
