import java.util.*;
public class Robot_and_Paths {
	
	static int MOD = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		String[] arr = str.split("\\s+");
		int m = Integer.valueOf(arr[0]);
		int n = Integer.valueOf(arr[1]);
		int p = Integer.valueOf(arr[2]);
		
		long[][] dp = new long[m+1][n+1];
		
		for(int i=0;i<p;i++) {
			str = s.nextLine();
			arr = str.split("\\s+");
			int x = Integer.valueOf(arr[0]);
			int y = Integer.valueOf(arr[1]);
			dp[x][y] = -1;
		}
		
		long ans = solve(dp,m,n)%MOD;
		System.out.println(ans);
		
	}
	
	
	static long solve(long[][] dp, int m, int n) {
		
		// corner case
		if(dp[1][1] == -1 || dp[m][n]==-1) {
			return 0;
		}
		
		// row
		for(int i=1; i<=m; i++) {
			if(dp[i][1]!=-1)
				dp[i][1] = 1;
			else
				break;
		}
		
		// col
		for(int i=1; i<=n; i++) {
			if(dp[1][i]!=-1)
				dp[1][i] = 1;
			else
				break;
		}
		
		for(int i=2; i<=m;i++) {
			for(int j=2; j<=n; j++) {
				
				if(dp[i][j]==-1)
					continue;
				
				long a,b;
				if(dp[i][j-1]!=-1)
					a = dp[i][j-1];
				else
					a = 0;
				
				if(dp[i-1][j]!=-1)
					b = dp[i-1][j];
				else
					b = 0;
				
				dp[i][j] = (a + b)%MOD;
			}
		}
		
		return dp[m][n]%MOD;
		
	}
	
	static void display(long[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
