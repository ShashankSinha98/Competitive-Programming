// AC on SPOJ

import java.util.*;
public class EKO_SPOJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		long T = s.nextInt();
		long W = s.nextInt();
		long[] trees = new long[(int)T];
		
		for(int i=0; i<T;i++) {
			trees[i] = s.nextLong();
		}
		
		long ans = min_height(T,W,trees);
		
		System.out.println(ans);
		

	}
	
	static long min_height(long T, long W, long[] trees) {
		
		long st = 0;
		long end = max(trees);
		
		long ans = -1;
		
		while(st<=end) {
			
			long mid = (st+end)/2;
			boolean fullfilled = woodRequirementOver(T,W,trees,mid);
			
			if (fullfilled) {
	            ans = Math.max(ans,mid);
	            st = mid+1;
			}else
	            end = mid-1;
			
		}
		
		return ans;
		
	}
	
	
	static boolean woodRequirementOver(long T,long W,long[] trees, long height) {
		
		long woods = 0;
		
		for(long t=0;t<T; t++) {
			long rem = trees[(int)t]-height;
			
			if(rem>0)
				woods+=rem;
		}
		
		return woods>=W;
	}
	
	static long max(long[] arr) {
		long ans = -1;
		
		for(int i=0;i<arr.length; i++) {
			if(ans<arr[i])
				ans = arr[i];
		}
		return ans;
	}

}
