public class Main_I {

    public static void main(String[] args) {
        float eps = 0.0001f;

        Berechnung b = new Berechnung(eps);

        System.out.println(b.berechne(0,5));

    }
}
