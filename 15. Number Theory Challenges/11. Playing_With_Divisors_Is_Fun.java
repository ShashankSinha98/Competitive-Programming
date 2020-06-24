import java.util.*;
public class Playing_With_Divisors_Is_Fun {
	
	static int MOD = 1000000007;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		
		int x = s.nextInt();
		long[] A = new long[x];
		
		
		long no_of_div = 1;
		
		for(int i=0; i<x; i++) {
			A[i] = s.nextLong();
			no_of_div = (no_of_div * (A[i]+1))%MOD;
		
		}
		
		
		long ans = 1;
		
		long mul_mod_inv_of_2 = ModuloInv(2, MOD);
		
		for(int i=0; i<x; i++) {
			A[i] = (A[i]*no_of_div)%MOD;
			A[i] = (A[i]*mul_mod_inv_of_2)%MOD;

			ans=(ans*(A[i]+1))%MOD;
		}
		
		display(A);
	
		System.out.println(ans);
			
	}
	
	static int GCD(int a,int b) {
		return b==0? a:GCD(b,a%b);
	}
	
	static long x,y;
	
	static void ExtendedEuclid(int a,int b) {
		
		if(b==0) {
			x = 1;
			y = 0;
			return;
		}
		
		ExtendedEuclid(b, a%b);
		
		long cx = y;
		long cy = x - (a/b)*y;
		
		x = cx;
		y = cy;
		
	}
	
	static void display(long[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static long ModuloInv(int a,int b) {
		
		if(GCD(a,b)!=1) {
			return -1;
		} else {
			ExtendedEuclid(a, b);
			return (x+b)%b;
		}
	}
	
}
