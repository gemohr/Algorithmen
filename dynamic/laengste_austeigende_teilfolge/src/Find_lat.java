import java.nio.IntBuffer;
import java.util.List;

public class Find_lat {

    List<Integer> a;
    IntBuffer v, vPred;
    int imax;
    public Find_lat(List<Integer> list){
        this.a = list;
        this.v = IntBuffer.allocate(list.size());
        this.vPred = IntBuffer.allocate(list.size());
    }


    public void berechne(){

        imax = 0;
        int n = a.size();
        //setze Startwert für neue Teilfolge
        v.put(0);
        vPred.put(-1);
        //Diese For durchläuft die Liste vom Index 1 an
        for(int i = 1; i<n; i++){
            //Neue Teilfolge Initialisieren
            v.put(0);
            vPred.put(-1); // bedeutet es gibt keinen Vorgänger
            //Durchläuft die von 0 bis i --> für die Vergleiche
            for (int j = 0; j<i; j++){
                //vergleicht die Elemente von 0 bis i ob alle Elemente kleiner i sind, und ob die Teilfolge in v(j)+1 größer v(i) ist
                if(a.get(j) < a.get(i) && v.get(j) +1 >v.get(i)){
                    //
                    v.put(v.position() -1,v.get(j)+1); //hier wird die länge der Teilfolge um 1 erhöht
                    vPred.put(vPred.position() -1, j);//setzte einen Vorgänger der von i als index von der Eingabe Liste
                }
                //falls eine neue Längste Teilfolge gefunden wurde setzte den Maxwert der die Längste Teilfolge enthält auf die neue Längste Teilfolge
                if(v.get(i) >v.get(imax)) imax = i;
            }
        }
    }

    public void ausgabe(int i){
        if(vPred.get(i) +1 != 0)
            ausgabe(vPred.get(i));

        System.out.print(a.get(i)+", ");

    }


    void print(){
        a.forEach( x ->{
            System.out.print(x+", ");
        });
        System.out.println("Längste aufsteigende Teilfolge: "+ (v.get(imax) + 1));
        ausgabe(imax);
    }


}
