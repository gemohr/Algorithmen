public class Main_NT {
        public static void main(String[] args) {
            //Anzahlen an Reihen auf dem Schachfeld
            int n = 4;
            int loesungen = 0;
            /*
             *  ein dimensionales Array reicht aus, da es in einer Reihe maximal einen Turm gibt
             *  also gibt x[reihe] an, an welcher Stelle der Reihe der Turm steht
             */
            int x [] = new int[n];
            //Reihe in der die Tuerme stehen
            int reihe = 0;
            //setzte den ersten Turm zubeginn auf -1;
            x[reihe] = -1;
            //wird solange ausgeführt wie wir uns auf einer gültigen Reihe befinden (0...n-1)
            while (reihe >= 0){
                //initial auf false, da hier noch nichts gefunden wurde
                boolean gefundeneZelle = false;
                //sucht die nächst mögliche Spalte in der ein Turm platziert werden kann ohne ein anderer bedrohen wird
                while (!gefundeneZelle && x[reihe] < n - 1){
                    //wenn Spalte gefunden, dann erhöhe in Reihe die Spalte auf die Gefundene Nummer und
                    //setzte gefundeneZelle auf true als Abbruchbedingung für die while
                    x[reihe]++;
                    gefundeneZelle = true;
                    for (int i = 0; i < reihe; i++)
                        //Suche ob in einer Reihe schon ein Turm Steht
                        if(x[i] == x[reihe]) {
                            gefundeneZelle = false;
                        }
                    }
                //wenn eine ungefährdete Spalte x[reihe] gefunden wurde
                    if(gefundeneZelle){
                        //entweder haben wir eine Lösung gefunden oder wir gehen auf die nächste Reihe
                        if(reihe == n - 1){
                            System.out.print("gefundene Lösung: ");
                            for(int i: x){
                                System.out.print(i+1);
                                System.out.print(" ");
                            }
                            System.out.println();
                            loesungen++;
                        }
                        //gehe zur nächsten Reihe
                        else x[++reihe] = -1;
                    }
                    //falls keine unbedrohte Spalte gefunden wird gehe eine Reihe zurück und Suche eine neue Lösung
                    else reihe--;
                }
            System.out.println("Für "+n+" Reihen wurden "+loesungen+" gefunden");
            }
    }
