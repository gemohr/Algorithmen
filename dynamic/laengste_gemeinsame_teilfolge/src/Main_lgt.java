import java.util.ArrayList;
import java.util.List;

public class Main_lgt {

    public static void main(String[] args) {

        int [] x = {10,4,20,10,40,2,0,60};
        int [] y = {4,90,7,10,70,2,71,81,0};

        //Typischer Dynamischer Programmierungs Zwischenspeicher
        int dp [][] = new int[x.length+1][y.length+1];

        //Berechnung der Teilfolge aus den Arrays x und y
        for(int i = 1;i <= x.length; ++i){
            for (int j = 1; j<=y.length; ++j){
                //wenn die gleichen zahlen vorkommen dann addiere bei i, j in db eine 1 da bedeutet das ein teil einer Teilfolge gefunden wurde
                if(x[i - 1] == y[j - 1]){
                    dp[i][j] = dp[i - 1][j- 1 ] +1;
                    continue;
                }
                if(dp[i - 1][j] >= dp[i][j - 1]) //wenn über der jetzigen Position eine Größere Zahl steht als in der Linken Position dann nehme die Zahl in der darüber liegenden Zelle
                    dp[i][j] = dp[i-1][j];
                else //ansonsten setze, die von der jetztigen Position, linke Zahl in Pos(i,j)
                    dp[i][j] = dp[i][j-1];
            }
        }


        //Ausgabe der Längsten Gemeinsamen Teilfolge
        List<Integer> ausgabe = new ArrayList<>();
        int i = x.length, j = y.length;
        //Abbruchbedingung, da wenn beide Indizes die 0 erreicht hat, dann ist das Ende des Feldes dp erreicht.
        while(i != 0 || j != 0){
            //füge die Zahlen der ausgabe hinzu wenn, die Indizes > 0 sind und wenn die Zahlen in den Folgen gleich sind
            if(i !=0 && j != 0 && x[i - 1] == y[j - 1]){
                ausgabe.add(x[i - 1]);
                i--;
                j--;
                continue;
            }
            //wenn die zahl über der jetzigen Pos gleich der jetztigen Pos ist, dann kein weiteres Teilfolgen Element gefunden --> reduziere i um eins (wenn 0 erreicht dann nicht mehr in diese If sonst Index out of Bound)
            if(i != 0 && dp[i][j] == dp[i - 1][j]){
                i--;
                continue;
            }
            //wenn die link neben der jetzigen Pos gleich der jetztigen Pos ist, dann kein weiteres Teilfolgen Element gefunden --> reduziere j um eins (wenn 0 erreicht dann nicht mehr in diese If sonst Index out of Bound)
            if(j != 0 && dp[i][j] == dp[i][j-1]){
                j--;
            }
        }
        int index = 0;
        System.out.println("Längste gemeinsame Teilfolge von x und y ist: " + dp[x.length][y.length]);
        System.out.print("Und die Teilfolge ist: {");

        for (int k = ausgabe.size()-1; k >= 0; k--){
            if(k == 0) {
                System.out.print(ausgabe.get(k)+"}");
            }else{
                System.out.print(ausgabe.get(k)+", ");

            }
        }

    }
}
