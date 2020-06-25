import java.util.*;

public class Find_It {
	
	static int LIM = 100006;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		

		
		int N = s.nextInt();
		int[] Narr = new int[N];
		for(int i=0; i<N;i++) {
			Narr[i] = s.nextInt();
			
		}
		
		int K = s.nextInt();
		int[] Karr = new int[K];
		for(int i=0; i<K; i++) {
			Karr[i] = s.nextInt();
		}
		
		int[] cnt = new int[LIM];
		for(int i=0; i<N; i++) {
			cnt[Narr[i]]+=1;
		}
		
		
		long[] sum = new long[LIM];
		sum[1] = N;
		for(int i=2; i<LIM; i++) {
			for(int j=i;j<LIM; j+=i) {
				sum[i] += cnt[j];
			}
		}
		
		
		
		for(int i=0; i<K; i++) {
			System.out.println(sum[Karr[i]]);
		}
		
		
	}
	
	static void display(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}


}
