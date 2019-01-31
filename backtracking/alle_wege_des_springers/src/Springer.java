public class Springer {

    int n;
    int [][] schachbrett;
    int loesungen;

    public Springer(int n){
        this.n = n;
        this.schachbrett = new int[n][n];
    }

    public void start(int x, int y){
        loesungen = 0;
        //setzte Startposition
        schachbrett[x-1][y-1] = 1;
        this.berechne(x-1,y-1,1);
    }
    private void berechne(int x, int y, int schritte){
        // wenn Schritte = n*n dann ist das Feld durchschritten und die Rekursion bricht ab und die Lösungen werden ausgegeben.
        if((n * n) == schritte){
            System.out.println("Lösung: "+ (++loesungen));
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.printf("%3d ",schachbrett[i][j]);
                }
                System.out.println();
            }
            return;
        }

        int dx, dy, xneu, yneu;
        // die möglichen Schritte die ein Springer von x aus gehen kann -2,-1,0,1,2
        for (dx = -2; dx < 3; dx++){
            //die möglichen Schritte die ein Springer von x aus gehen kann -2,-1,0,1,2
            for (dy = -2; dy < 3; dy++){
                //hier wird festgestellt ob der Schritt tatsächlich ein valider Schritt ist
                // --> x = x-2 dann muss y = y-1 oder y=y+1 sein (und -2 * -1 = -2 und der Betrag ist 2)
                if(Math.abs(dx * dy) == 2){
                    //berechne den nächstn Möglichen Schritt
                    xneu = x + dx;
                    yneu = y + dy;
                    /* Überprüfung ob Schritt:
                     * auf dem Schachbrett --> (0 <= xneu && xneu < n) && (0 <= yneu && yneu < n)
                     * und ob das Feld schon besucht würde schachbrett[xneu][yneu] == 0
                     */
                    if(0 <= xneu && xneu < n && 0 <= yneu && yneu < n && schachbrett[xneu][yneu] == 0){
                        //wenn neue Position gefunden schreibe die Nummer des Zuges an die Position (xneu,yneu)
                        schachbrett[xneu][yneu] = schritte + 1;
                        // starte mit der Überprüfung der neuen Position
                        berechne(x + dx,y + dy,(schritte+1));
                        // nachdem eine Lösung gefunden würde schreibe wieder 0 in die Position sonst würde man nur eine Lösung bekommen
                        // --> Aufrufstack bei Rekursion
                        schachbrett[xneu][yneu] = 0;
                    }
                }
            }
        }
    }

}
