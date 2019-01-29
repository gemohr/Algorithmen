public class Main_kanp {

    public static void main(String[] args) {
    Knapsack k = new Knapsack();
    int []  elementPreis  = {3000,2000,1500};
    int []  elementGewicht = {4,3,1};
    int capazität = 4;
        System.out.println("Maximaler Preis: "+k.knapsack(capazität, elementGewicht, elementPreis));
    }
}
