public class Main_BINO {

    // n über k --> (!n)/(k! * (n-k)!) -->
    public static void main(String[] args) {
        Binominalkoeffizienten_dyn bin_d = new Binominalkoeffizienten_dyn();
        System.out.println(bin_d.bin(10,5));

    }
}
