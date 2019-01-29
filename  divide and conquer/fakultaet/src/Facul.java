public class Facul {


    public int fac(int n){

        if(n == 1 || n == 0) return 1;
        return n * fac(n-1);

    }

}
