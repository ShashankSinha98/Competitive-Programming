import java.math.BigInteger;
import java.util.Scanner;

public class Big_GCD{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Input a(10^250):");
		BigInteger big_a = s.nextBigInteger();
		System.out.println("Input b(10^7):");
		int b = s.nextInt();
		
		BigInteger b2 = BigInteger.valueOf(b);
		int mod = big_a.mod(b2).intValue();
		
		System.out.println("GCD: "+GCD(mod,b));
		

	}
	
	static int GCD(int a,int b) {
		
		return b==0?a:GCD(b,a%b);
	}

}
