public class Hanoi {


    /**
     *
     * @param A Quellposition
     * @param C Zielposition
     * @param B Hilfsposition
     * @param h Anzahl an Scheiben
     */
    public void bewege(char A, char C, char B, int h){

        if(h != 0){

        bewege(A,B,C,h - 1); //Schritt 1 --> bewege alle Elemente, bis auf die Letzte Scheibe, von der Quelle zur Hilfsposition (A->B)
        System.out.println("lege die Scheibe von Turm " + A + " nach Turm " + C ); //Schritt 2 --> bewege unterste Scheibe auf die Zielposition (A->C)
        bewege(B,C,A,h - 1); //Schritt 3 --> bewege alle Elemente von der Hilfsposition auf die Zielposition (B->C)

        }
    }


}
