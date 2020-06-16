// Accepted on CodeForces

import java.util.*;
public class Yet_Another_Counting_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		s.nextLine();
		while(t--!=0) {
			
			String str = s.nextLine();
			String[] strArr = str.split("\\s+");
			int a = Integer.valueOf(strArr[0]);
			int b = Integer.valueOf(strArr[1]);
			int q = Integer.valueOf(strArr[2]);
			
			int[] arr = new int[(a*b)];
			int[] sum_arr = new int[(a*b)];
			
			for(int i=1; i<arr.length; i++) {
				if((i%a)%b != (i%b)%a) {
					arr[i]=1;
				}
				sum_arr[i] = sum_arr[i-1]+arr[i];
			}
			
			//display(arr);
			//display(sum_arr);
			
			while(q--!=0) {
				String qstr = s.nextLine();
				String[] qstrArr = qstr.split("\\s+");
				long li = Long.valueOf(qstrArr[0]);
				long ri = Long.valueOf(qstrArr[1]);
				
				long no_of_arr = (li/(a*b));
				long left_part = li%(a*b);
				long li_sum = 0;
				
				if(left_part != 0) {
					li_sum = no_of_arr*sum_arr[(a*b)-1] + sum_arr[(int)left_part-1];
				} else {
					li_sum = no_of_arr*sum_arr[(a*b)-1];
				}
				
				
				no_of_arr = (ri/(a*b));
				left_part = ri%(a*b);
				long ri_sum = no_of_arr*sum_arr[(a*b)-1] + sum_arr[(int)left_part];
				//System.out.println("li sum: "+li_sum);
				//System.out.println("ri sum: "+ri_sum);
				System.out.println(ri_sum-li_sum);
				
			}
		}

	}
	
	static void display(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}

}
