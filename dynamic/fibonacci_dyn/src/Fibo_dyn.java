public class Fibo_dyn {

    public int fib(int n){
        int [] f = new int [n+1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i<=n; i++){
            int k =  f[i-1] + f[i-2];
            f[i] = k;
        }
        return f[n];

    }

}
