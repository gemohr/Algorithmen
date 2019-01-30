import java.util.ArrayList;
import java.util.List;

public class Main_svp {
    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(1l);
        list.add(2l);
        list.add(3l);
        list.add(4l);
        long [] array = new long[list.size()+1];
        for (int i = 0; i<list.size();i++) array[i]=list.get(i);

        //abbruch falls array leer
        if(array.length == 0) return;

        Berechne b = new Berechne(list.size(),array);
        b.berechne();
        b.print();

    }
}
