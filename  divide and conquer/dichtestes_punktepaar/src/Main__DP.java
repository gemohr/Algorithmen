
public class Main__DP {
    public static void main(String[] args) {

        Punkt[] punkte  = {
         new Punkt(13,5),
       new Punkt(323,46),
         new Punkt(112,2),
                new Punkt(1,234),
                new Punkt(534,89),
                new Punkt(23,1345),
                new Punkt(42,578),
                new Punkt(543,1234),
                new Punkt(2352,2324),
                new Punkt(234,234),
                new Punkt(32,34),
                new Punkt(12,123)};

        Search search = new Search();
        System.out.println(search.sort(punkte) + " " + search.either() + " "+ search.other());
    }
}
