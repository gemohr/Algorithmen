import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_aehnlich {

    public static void main(String[] args) {

        int mod = 10;

        //Additions Elemente
        List<Integer> vElem = new ArrayList<>();
        vElem.add(45345);
        vElem.add(65892);
        vElem.add(78678);
        vElem.add(111153);
        vElem.add(190223);
        vElem.add(675451);
        vElem.add(543876);
        vElem.add(23980);
        vElem.add(99453);
        vElem.add(990121);
        vElem.add(656555);
        vElem.add(432908);
        vElem.add(12361);
        vElem.add(65432);
        vElem.add(453219);
        //DP speicher --> befüllen mit -1 um zu zeigen das kein Eintrag vorhanden ist
        int vLast [] = new int[mod];
        Arrays.fill(vLast,-1);
        // Durchlaufe die Addidtionselement Liste
        for(int i=0; i< vElem.size();i++){
            //hole das Element ite Element aus der Liste
            int aux = vElem.get(i);
            //aux%1000 gibt die letzten 3 Ziffern der Zahl zurück, wenn dort -1 dann noch kein Eintrag für diese Zahl allso speichere dort den index für die Zahl in der vElem Liste
            if(vLast[aux%mod] == -1) vLast[aux%mod]=i;

            //Durchlaufe das Array von 0 bis 1000 um die möglichen 3 letzten Ziffern der Summen zu erhalten die entstehen wenn wir aux auf die bereits errechnete Summe j addieren
            for (int j = 0;j<mod; j++){
                //vLast[j] != -1 --> überprüfen ob es einen inhalt gibt; j != aux % 1000 --> überprüfung das nocht noch mals die geleiche zahl berechnet werden muss ; vLast[j] != i --> überprüfen dass nicht die Gleiche Zahl addiert wird;
                if((vLast[j] != -1) && (j != aux % mod) && (vLast[j] != i)){
                    //berechne die summe von element an der Stelle i (aux) und j ?
                    int sum = (aux + j) % mod;
                    // wenn noch kein Eintrag an dieser Stelle ist dann füge den index des elements in das Array an der Stelle der Summe
                    if(-1 == vLast[sum]) vLast[sum] = i;
                }
            }
        }

        int i = 54546 % mod;
       // int i = 234233 %1000;
        if(i != 0) vLast[0] = -1;

        for (int j = 0;j<mod; j++) {
            System.out.print(","+vLast[j]+" ");
        }
        System.out.println();
        //wenn man bei i == -1 rauskommt wurde keine lösung gefunden
        if(vLast[i] != -1){
            //solange suchen bis wir bei dem letzen element angekommen sind, da danach keine Elemente mehr kommen können.
            while (vLast[i] >= 0){
                System.out.print(" ");
                System.out.print(vElem.get(vLast[i]));
                int j = i;
                //wenn i < meinem element mod 1000 ist bsp. i=127 < 543--> 1000+ 127 + 543 = 548 --> 548 ist mein neuer nächster summand in der Reihe
                if(i< vElem.get(vLast[i]) % mod)
                    i = mod + i - (vElem.get(vLast[i]) %mod); //1569 - 980 = i
                else
                    i =  i - (vElem.get(vLast[i]) %mod);
                //wenn element besucht dann wieder -1 setzen da wir nicht nochmals an diesen Punkt kommen wollen sonst entsteht ein zyklus bzw. rechnen wir zwei gleich zahlen zusammen.
                vLast[j] = -1;
            }
        } else System.out.println("Keine Lösung");
        System.out.println();
        for (int j = 0;j<mod; j++) {
            System.out.print(","+vLast[j]+" ");
        }
    }

}
