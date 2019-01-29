
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;


public class Main_Astar {
    public static void main(String[] args) {

        Node saarbruecken = new Node();
        Node kaiserslautern = new Node();
        Node karlsruhe = new Node();
        Node frankfurt = new Node();
        Node ludwigshafen = new Node();
        Node heilbronn = new Node();
        Node wuerzburg = new Node();
        saarbruecken.name = "Saarbrücken";
        kaiserslautern.name = "Kaiserslautern";
        karlsruhe.name = "Karlsruhe";
        frankfurt.name = "Frankfurt";
        ludwigshafen.name = "Ludwigshafen";
        heilbronn.name = "Heilbronn";
        wuerzburg.name = "Würzburg";

        saarbruecken.h = 222;
        kaiserslautern.h = 158;
        karlsruhe.h = 140;
        frankfurt.h = 96;
        ludwigshafen.h = 108;
        heilbronn.h = 87;
        wuerzburg.h = 0;

        kaiserslautern.vorgänger = new HashMap<>();
        karlsruhe.vorgänger = new HashMap<>();
        frankfurt.vorgänger = new HashMap<>();
        ludwigshafen.vorgänger = new HashMap<>();
        heilbronn.vorgänger = new HashMap<>();
        wuerzburg.vorgänger = new HashMap<>();

        karlsruhe.vorgänger.put(145,saarbruecken);
        kaiserslautern.vorgänger.put(70,saarbruecken);
        frankfurt.vorgänger.put(103,kaiserslautern);
        ludwigshafen.vorgänger.put(53,kaiserslautern);
        heilbronn.vorgänger.put(84,karlsruhe);
        wuerzburg.vorgänger.put(116,frankfurt);
        wuerzburg.vorgänger.put(183,ludwigshafen);
        wuerzburg.vorgänger.put(102,heilbronn);

        saarbruecken.nachfolger = new HashMap<>();
        kaiserslautern.nachfolger = new HashMap<>();
        karlsruhe.nachfolger = new HashMap<>();
        frankfurt.nachfolger = new HashMap<>();
        ludwigshafen.nachfolger = new HashMap<>();
        heilbronn.nachfolger = new HashMap<>();

        saarbruecken.nachfolger.put(145,karlsruhe);
        saarbruecken.nachfolger.put(70,kaiserslautern);

        kaiserslautern.nachfolger.put(53,ludwigshafen);
        kaiserslautern.nachfolger.put(103,frankfurt);
        karlsruhe.nachfolger.put(84,heilbronn);

        frankfurt.nachfolger.put(116,wuerzburg);
        ludwigshafen.nachfolger.put(183,wuerzburg);
        heilbronn.nachfolger.put(102,wuerzburg);

        System.out.println(kaiserslautern.g);

        Astern astern = new Astern();
        System.out.println(astern.findPath(saarbruecken));

        System.out.println(kaiserslautern.g);

        Map<Integer, Node> path = new TreeMap<>();

        astern.closeList.forEach((f,node) -> {
            path.put(f,node);
        });

        path.forEach((key, node) ->{
            System.out.println(key + " " + node.name + " " + node.h);
        });
    }
}
