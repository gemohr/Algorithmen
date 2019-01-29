public class Knapsack {

  private int max(int a, int b){ return (a > b)? a : b ;}

  //O(capazität*n)
  public int knapsack(int capazitaet, int elementeGewicht [], int elementPreis []){

        int n = elementPreis.length;
        int dp [][] = new int[n+1][capazitaet+1];
        for(int i = 1; i<= n; i++) {
            for(int j = 0; j<=capazitaet; j++) {
                    if(elementeGewicht[i-1] <=j) //Überprüfung ob das Element mit dem Gewicht [i-1] in den Rucksack passt
                        dp[i][j] = max(elementPreis[i - 1] + dp[i - 1][j - elementeGewicht[i - 1]], dp[i - 1][j]); //überprüfen ob das alte Element mehr Wert besitz als das neue
                    else dp[i][j]=dp[i-1][j]; // falls das Element nicht passt bleibe bei der alten Belegung
            }
        }



        //Ausgabe optional
        for(int i = 0; i<= n; i++) {
            for (int j = 0; j <= capazitaet; j++) {
                if(Integer.toString(dp[i][j]).length() == 1)
                System.out.print("000"+dp[i][j]+" ");
                else System.out.print(""+dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][capazitaet];
    }


}
