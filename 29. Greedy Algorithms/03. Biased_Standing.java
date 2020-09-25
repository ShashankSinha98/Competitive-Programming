import java.util.*;
public class Biased_Standing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while(t--!=0) {
			int n = s.nextInt();
			s.nextLine();
			ArrayList<Integer> list = new ArrayList<>();
			int[] arr = new int[n+1];
			
			for(int i=0; i<n; i++) {
				String[] strarr = s.nextLine().split("\\s+");
				arr[Integer.valueOf(strarr[1])]++;
			}
			for(int i=0; i<=n; i++) {
				if(arr[i]>0) {
					while(arr[i]>0) {
						list.add(i);
						arr[i]-=1;
					}
				}
			}
			
			
			
			long ans = 0;
			for(int i=1; i<=n; i++) {
				ans+=Math.abs(list.get(i-1)-i);
			}
			
			System.out.println(ans);
		}

	}

}
