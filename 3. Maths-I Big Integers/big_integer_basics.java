import java.util.*;
import java.math.BigInteger;
public class big_integer_basics{

    static void playWithBigInt(){

        Scanner s = new Scanner(System.in);

        
        // Creating BigInteger from String
        BigInteger a = new BigInteger("12");
        BigInteger b = new BigInteger("12");

        a = a.add(b);
        System.out.println(a);
        a = a.multiply(b);
        System.out.println(a);

        // Read String i/p and convert it into BigInteger
        String str = s.next();

        BigInteger c = new BigInteger(str);
        c = c.subtract(b);
        System.out.println(c);

        // Bit Counts- Total Set bits
        System.out.println(c.bitCount());

        // Total No of Bits
        System.out.println(c.bitLength());
        


        // Integer to Big Integer
        int n1 = s.nextInt();
        int n2 = s.nextInt();

        BigInteger b3 = BigInteger.valueOf(n1);
        BigInteger b4 = BigInteger.valueOf(n2);

        // Print GCD
        System.out.println(b3.gcd(b4));

        // Interpret the no. in given base
        BigInteger b5 = new BigInteger("1001",2);
        System.out.println(b5);

        // Power of a number
        System.out.println(b3.pow(2));

        


    }
    public static void main(String[] args) {
        
        playWithBigInt();

    }
}