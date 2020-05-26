import java.util.*;
import java.lang.*;
import java.math.BigInteger;

class julka_spoj
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);

        int t = 10;
        for(int i=0; i<10; i++){
            BigInteger total = s.nextBigInteger();
            BigInteger excess = s.nextBigInteger();

            apples_count(total,excess);
        }
	}
	
	public static void apples_count(BigInteger total, BigInteger excess){


        BigInteger natalia = (total.subtract(excess)).divide(BigInteger.valueOf(2));
        BigInteger klaudia = natalia.add(excess);

        System.out.println(klaudia);
        System.out.println(natalia);
    }
}