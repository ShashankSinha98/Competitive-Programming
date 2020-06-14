import java.util.*;
public class Math_Day {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		s.nextLine();
		while(t--!=0) {
			
			String str = s.nextLine();
			String[] strArr = str.split("\\s+");
			int A = Integer.valueOf(strArr[0]);
			int N = Integer.valueOf(strArr[1]);
			int P = Integer.valueOf(strArr[2]);
			
			
			long ans = A;
			
			for(int i=1; i<=N; i++) {
				ans = power(ans,i,P);
			}
			
			System.out.println(ans);
		}
		

	}
	
	static long power(long A,int N,int P) {
		
		if(N==1)
			return A%P;
		
		if(N==0)
			return 1;
		
		if((N&1)==1) {
			long X = power(A,N-1,P);
			return (A*X)%P;
		} else {
			long X = power(A,N/2,P);
			return (X*X)%P;
		}
	}

}
