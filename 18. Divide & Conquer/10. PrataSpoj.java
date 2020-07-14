// AC on SPOJ

import java.util.Arrays;
import java.util.Scanner;
public class PrataSpoj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t--!=0) {
		int p = s.nextInt();
		s.nextLine();
		String str = s.nextLine();
		String[] strArr = str.split("\\s+");
		int c = Integer.valueOf(strArr[0]);
		int[] chef = new int[c];
		
		for(int i=0;i<c; i++) {
			chef[i] = Integer.valueOf(strArr[i+1]);
		}
		
		Arrays.sort(chef);
		
		long ans = solve(p, c, chef);
		System.out.println(ans);
		}
		
	}
	
	static long sumAP(int n, int a) {
		long res;
		res = (2*a+(n-1)*a);
		res = (res*n)/2;
		return res;
	}
	
	static boolean possibleToCook(int p, int c, int[] chefsRank, long minTime) {
		
		int parataMade = 0;
		//System.out.println("MIN TIME : "+minTime);
		for(int i=0; i<c; i++) {
			int time = 0;
			int inc = chefsRank[i];
			int cR = chefsRank[i];
			
			while(time+cR<=minTime) {
				parataMade+=1;
				time+=cR;
				cR+=inc;
				//System.out.println("PM: "+parataMade+
					//	" time: "+time+" chef Rank: "+
						//chefsRank[i]);
			}
			
			if (parataMade>=p)
				return true;
		}
		
		return false;
	}
	
	static long solve(int p,int c, int[] chefRank) {
		
		long st = 0;
		long end = sumAP(p, chefRank[0]);
		
		long ans = Integer.MAX_VALUE;
		
		while(st<=end) {
			
			long mid = (st+end)/2;
			
			boolean possible = possibleToCook(p,c,chefRank,mid);
			
			if (possible) {
				end = mid-1;
				ans = Math.min(ans, mid);
			} else {
				st = mid+1;
			}
		}
		return ans;
	}

}
