import java.math.BigInteger;

public class Karatsuba {


    public long multi(long u, long v){
        //wenn u oder v kleiner 10 dann ist die normale multiplikation schneller
       if(v<10 || u <10) return u*v;

       long n,x,y,z,w,wy,wz,xy,xz,ergebnis,n2;

        String uString = Integer.toString((int)u);
        String vString = Integer.toString((int)v);

        //länge der längeren Zahl
        n = max(uString.length(),vString.length());
        n = (n/2);
        // teile die Zahl u in zwei teile
        w = Long.parseLong(strCopy(n, uString)[0]);
        x = Long.parseLong(strCopy(n, uString)[1]);
        // teile die Zahl v in zwei teile
        y = Long.parseLong(strCopy(n, vString)[0]);
        z = Long.parseLong(strCopy(n, vString)[1]);

        wy = multi(w,y);
        wz = multi(w,z);
        xy = multi(x,y);
        xz = multi(x,z);

         ergebnis = (wy * power(10,n*2) + (wz+xy) * power(10,n) + xz);

        return ergebnis;

    }

    public long power(long a, long b){

        return (long) Math.pow(a,b);
    }


    public long max(long u, long v){
        return u < v ? v:u;
    }
    public static String[] strCopy(long index, String string) {
        String	first = "",
                last = "";
        long actualIndex = string.length() - index;
        for (int i = 0; i<actualIndex; i++) {
            first+=string.charAt(i);
        }
        for (int i = (int)actualIndex; i<string.length(); i++) {
            last+=string.charAt(i);
        }
        return new String[] {first, last};
    }
}
