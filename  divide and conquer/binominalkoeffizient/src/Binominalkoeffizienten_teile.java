public class Binominalkoeffizienten_teile {
    public int bin(int n, int k){

        //basisfälle
        if(k == 0 || n == k) return 1;

        return bin(n-1,k) + bin(n-1,k-1);

    }
}
