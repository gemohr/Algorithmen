public class Catalanzahlen {

    public static void main(String[] args) {
        int n = 5;
        int [] c = new int[n+1];
        c[0]=1;

        for(int N = 0;N<n;N++) {
            c[N + 1] = 0;
            for (int k = 0; k <= N; k++) {
                c[N + 1] += c[k] * c[N - k];
            }

        }
        System.out.println(c[n]);
    }
}
