

import java.util.*;

public class Astern {

public TreeMap <Integer,Node> openlist = new TreeMap();
public TreeMap <Integer,Node> closeList = new TreeMap();

    public String findPath(Node startnode){
        startnode.g =0;

        openlist.put(0,startnode);

        // diese Schleife wird durchlaufen bis entweder
        // - die optimale Lösung gefunden wurde oder
        // - feststeht, dass keine Lösung existiert

        while (!openlist.isEmpty()){
            // Knoten mit dem geringsten f-Wert aus der Open List entfernen
            Node currentNode = openlist.firstEntry().getValue();
            int key = openlist.firstKey();
            openlist.remove(openlist.firstKey());

            // Wurde das Ziel gefunden?
            if(currentNode.nachfolger == null){closeList.put(key,currentNode); return "Path found";}

            // Der aktuelle Knoten soll durch nachfolgende Funktionen
            // nicht weiter untersucht werden, damit keine Zyklen entstehen
            closeList.put(key,currentNode);

            // Wenn das Ziel noch nicht gefunden wurde: Nachfolgeknoten
            // des aktuellen Knotens auf die Open List setzen
            expandNode(currentNode);
        }

        return "No Path found";
    }

    public void expandNode(Node currentNode){
        currentNode.nachfolger.forEach((kante, nachfolger) -> {
            // wenn der Nachfolgeknoten bereits auf der Closed List ist – tue nichts
            if(closeList.containsValue(nachfolger)) return;

            // Gesamt-Wert für den neuen Weg berechnen: Gesamt-Wert des Vorgängers plus
            // die Kosten der gerade benutzten Kante
            int new_g = currentNode.g + kante;

            // wenn der Nachfolgeknoten bereits auf der Open List ist,
            // aber der neue Weg nicht besser ist als der alte – tue nichts
            if(openlist.containsValue(nachfolger) & nachfolger.g <= new_g ) return;
            // neuer Gesamt-Wert speichern
            nachfolger.g = new_g;

            if(openlist.containsValue(nachfolger)){
                // f-Wert des Knotens in der Open List aktualisieren
                openlist.remove(getKey(nachfolger));
                openlist.put(new_g+nachfolger.h,nachfolger);
            }else{
                //Knoten mit f-Wert in die Open List einfügen
                openlist.put(new_g+nachfolger.h,nachfolger);
            }
        });

    }

    public int getKey( Node value) {
        for (Map.Entry<Integer,Node> entry : openlist.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
