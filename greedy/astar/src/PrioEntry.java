public class PrioEntry implements Comparable{

    public PrioEntry(Node node, int f) {
        this.node = node;
        this.f = f;
    }

    Node node;
    int f;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
