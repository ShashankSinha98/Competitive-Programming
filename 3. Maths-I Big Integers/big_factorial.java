import java.util.*;
import java.math.BigInteger;
public class big_factorial {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        System.out.println(fact(n));
    }

    public static BigInteger fact(int n){

        BigInteger res = BigInteger.valueOf(1);

        for(int i=1;i<=n;i++){
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res;
    }
    
}