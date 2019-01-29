import java.util.Comparator;

public class Punkt{
    public static final Comparator<Punkt> X_ORDER = new XOrder();
        public static final Comparator<Punkt> Y_ORDER = new YOrder();

    public Punkt(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x;
    public int y;



    private static class XOrder implements Comparator<Punkt> {
        public int compare(Punkt p, Punkt q) {
            if (p.x < q.x) return -1;
            if (p.x > q.x) return +1;
            return 0;
        }
    }
    // compare points according to their y-coordinate
    private static class YOrder implements Comparator<Punkt> {
        public int compare(Punkt p, Punkt q) {
            if (p.y < q.y) return -1;
            if (p.y > q.y) return +1;
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Punkt{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
