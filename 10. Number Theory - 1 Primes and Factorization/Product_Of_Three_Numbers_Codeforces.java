// Accepted on Codeforces
import java.util.*;
public class Product_Of_Three_Numbers_Codeforces {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t--!=0) {
			
			long N = s.nextLong();
			long a = Long.MAX_VALUE;
			long b = Long.MAX_VALUE;
			
			
			long i=2;
			for(;i<=(int)Math.sqrt(N); i++) {
				if(N%i == 0) {
					a = i;
					N = N/i;
					i++;
					break;
				}
			}
			
			for(;i<=(int)Math.sqrt(N); i++) {
				if(N%i == 0) {
					b = i;
					N = N/i;
					i++;
					break;
				}
			}
			
			
			
			if(a!=Long.MAX_VALUE && b!=Long.MAX_VALUE && a!=N && b!=N && N!=1) {
				System.out.println("YES");
				System.out.println(a+" "+b+" "+N);
			} else {
				System.out.println("NO");
			}
		}

	}

}
