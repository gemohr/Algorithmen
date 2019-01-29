import java.math.BigInteger;

public class Main_K
{
    public static void main(String[] args) {
        long u = 442452352,v=1233234245;
        Karatsuba k = new Karatsuba();
        System.out.println(u+" * "+v+" = "+k.multi(u,v));


    }
}
