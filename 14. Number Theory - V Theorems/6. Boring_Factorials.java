// Accepted on SPOJ

import java.util.*;
public class Boring_Factorials {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		s.nextLine();
		
		while(t--!=0) {
			String str = s.nextLine();
			String[] strArr = str.split("\\s+");
			long N = Long.valueOf(strArr[0]);
			long P = Long.valueOf(strArr[1]);
			
			if(P<=N) {
				System.out.println("0");
			} else {
				long ans = -1;
				for(long i=(N+1);i<=(P-1);i++) {
					ans = (ans * FastModExpo(i, P-2, P))%P;
				}
				System.out.println((ans+P)%P);
			}
		}

	}
	
	static long FastModExpo(long a,long b,long MOD) {
		
		long ans = 1;
		
		while(b!=0) {
			
			if((b&1)==1) {
				ans = (ans * a)%MOD;
			}
			b = b>>1;
			a = (a*a)%MOD;
		}
		
		return ans;
		
	}

}
