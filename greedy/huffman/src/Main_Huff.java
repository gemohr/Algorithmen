import java.util.Iterator;

public class Main_Huff {
    public static void main(String[] args) {
        Huffman h = new Huffman();
        //zu komprimierender Satz
        String satz = "Hallo Marco";
        // Baum erzeugen, Buchstaben hinzufügen
        for (int i = 0; i < satz.length(); i++) {
            h.add(satz.charAt(i));
        }
        //Baum abrufen
        System.out.println("----h.createTree() direktaufruf-----");
        Tree t = h.createTree();
        System.out.println("----h.printTree() direktaufruf-----");
        h.printTree();
        //Baum in die CharMap kopieren
        h.setCharMap(t, "");
        System.out.println("----Ausdrucken der charMap -----");
        Iterator ite = h.charMap.entrySet().iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
        System.out.println("----h.getCompressedCode direktaufruf-----");
        String chiffre = h.getCompressedCode(t, satz);
        System.out.println("Chiffre: " + chiffre);
    }
}
