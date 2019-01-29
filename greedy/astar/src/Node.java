import java.util.Map;

public class Node implements Comparable{

    public String name;
    public Map<Integer, Node> vorgänger;
    public Map<Integer, Node> nachfolger;
    public int h;
    public int g;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
