import java.util.ArrayList;
import java.util.List;

public class Main_lat {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(76);
        list.add(1);
        list.add(45);
        list.add(2);
        list.add(31);
        list.add(89);
        list.add(90);
        list.add(0);
        list.add(4);
        list.add(15);
        list.add(23);
        list.add(47);
        list.add(95);
        list.add(21);
        list.add(67);
        list.add(8);
        list.add(13);
        list.add(11);
        list.add(5);
        list.add(145);
        list.add(132);
        list.add(77);

        Find_lat find = new Find_lat(list);
        find.berechne();
        find.print();
    }
}
