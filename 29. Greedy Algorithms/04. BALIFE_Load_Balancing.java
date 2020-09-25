import java.util.*;
import java.io.*;
public class BALIFE_Load_Balancing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			int n = Integer.parseInt(br.readLine().trim());
			if(n==0)
				continue;
			if(n==-1)
				System.exit(0);
			
			
			ArrayList<Long> arr = new ArrayList<>();
			String[] strarr = br.readLine().trim().split("\\s+");
			for(int i=0; i<n; i++)
				arr.add(Long.valueOf(strarr[i]));
			
			
			long[] cumm = new long[n];
			cumm[0] = arr.get(0);
			long sum = arr.get(0);
			
			
			for(int i=1; i<n; i++) {
				cumm[i] = cumm[i-1]+arr.get(i);
				sum+=arr.get(i);
			}
			
			
			if(Double.valueOf(sum)/n!=sum/n) {
				System.out.println("-1");
			} else {
				long ans = solve(arr,cumm,n,sum);
				System.out.println(ans);
			}
			br.readLine();
			//br.readLine();

		}
	}
	
	static long solve(ArrayList<Long> arr, long[] cumm, int n,long sum) {
		long ans = 0;
		long each = sum/n;
		
		for(int i=1;i<n;i++) {
			ans = Math.max(ans, Math.abs(cumm[i-1]-(each*i)));
		}
		return ans;
	}

}
