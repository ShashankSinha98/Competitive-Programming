import java.math.BigInteger;
import java.util.*;
public class Evaluating_Functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		BigInteger X = s.nextBigInteger();
		
		BigInteger FX = BigInteger.valueOf(3).multiply(X.multiply(X)).subtract(X).add(BigInteger.valueOf(10));
		System.out.println(FX);
		BigInteger GX = (BigInteger.valueOf(4).multiply(X.multiply(X).multiply(X)))
						.add(BigInteger.valueOf(2).multiply(X.multiply(X)))
								.subtract(BigInteger.valueOf(5).multiply(X))
								.add(BigInteger.valueOf(4));
		System.out.println(GX);
		System.out.println(FX.add(GX));
		
		

	}

}
