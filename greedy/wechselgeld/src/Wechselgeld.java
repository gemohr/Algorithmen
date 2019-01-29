import java.text.NumberFormat;
import java.util.*;

public class Wechselgeld {
    ArrayList<Double> geld = new ArrayList<Double>(Arrays.asList(500.0,200.0,100.0,50.0,20.0,10.0,5.0,2.0,1.0,0.5,0.2,0.1,0.05,0.02,0.01));
    ArrayList<Double> ausgabe = new ArrayList<>();


    public ArrayList<Double> wechselgeld(double betrag){
       double rem_heraus = 0;
       //index für die Arraylist geld;
       int i = 0;
       //Laufe solangen bis der betrag erreicht ist
        while (rem_heraus < betrag){
            //wenn der rem_betrag + die Aktuelle Größte Geldnote kleiner ist dann addiere auf rem_heraus dazu
            if(rem_heraus+geld.get(i) <= betrag) {
                rem_heraus+=geld.get(i);
                rem_heraus = rem_heraus * 100;
                rem_heraus = Math.round(rem_heraus);
                rem_heraus = rem_heraus / 100;
                //füge die Geldnote der Ausgabe hinzu
                ausgabe.add(geld.get(i));
                //wenn die Aktuelle Geldnote nochmals in den rem_heraus passt und noch kleiner dem Betrag ist; sonst setzte den index um eins nach oben
                if(geld.get(i)>betrag-rem_heraus) i = 0;
                else i++;
            } else if(geld.get(i)> (betrag-rem_heraus)){ // wenn die Aktuelle Geldnote nicht in den rem_betrag passt dann lösche aus der Liste und setzte index wieder auf 0
                geld.remove(i);
                i = 0;
            }
        }
        return ausgabe;

    }

}
