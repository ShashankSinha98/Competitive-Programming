import java.util.*;
import java.lang.*;
public class Factorial_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		s.nextLine();
		
		while(t--!=0) {
			
			int ans = Integer.MAX_VALUE;
			
			String str = s.nextLine();
			String[] strArr = str.split("\\s+");
			int n = Integer.valueOf(strArr[0]);
			int k =  Integer.valueOf(strArr[1]);
			int lim_k = k;
			
			for(int i=2; i*i<=lim_k; i++) {
				
				if(k%i==0) {
					
					int k_cnt = 0;
					while(k%i==0) {
						
						k_cnt+=1;
						k/=i;
						
					}
					
					long pi = i;
					int n_cnt = 0;
					while(pi<=n) {
						n_cnt += n/pi;
						pi = pi*i;
					}
					
					ans = Math.min(ans, n_cnt/k_cnt);

				}
				
				
			}
			
			
			if(k>1) {
				long pi = k;
				int n_cnt = 0;
				while(pi<=n) {
					n_cnt += n/pi;
					pi = pi*k;
				}
				
				ans = Math.min(ans, n_cnt/1);

			}
			
			if(ans == Integer.MAX_VALUE) {
				ans = 0;
			}
			
			System.out.println(ans);
			
			
		}

	}
	
	
	static void display(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}

}
