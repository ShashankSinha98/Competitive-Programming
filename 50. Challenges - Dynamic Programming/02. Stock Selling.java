import java.util.*;
public class Stock_Selling {
    public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
			
		while(t--!=0){
					ArrayList<Integer> arr = new ArrayList<>();


		while(true){
			int num = s.nextInt();
			arr.add(num);
			if(arr.size()>2 && arr.size()==arr.get(1)+2)
				break;
		}

		int k = arr.get(0);
		int n = arr.get(1);
		int prices[] = new int[n];

		for(int i=0;i<n;i++){
			prices[i] = arr.get(i+2);
		}

		System.out.println(max_profit(prices,n,k));

		}

    }

static int max_profit(int[] prices, int n, int k){
		int[][] dp = new int[k+1][n+1];

		for(int t=1;t<=k;t++){
			int maxdiff = Integer.MIN_VALUE;
			for(int d=1;d<=n;d++){
				maxdiff = Math.max(maxdiff,dp[t-1][d]-prices[d-1]);
				dp[t][d] = Math.max(dp[t][d-1],maxdiff+prices[d-1]);
			}
		}

		return dp[k][n];
	}
}
