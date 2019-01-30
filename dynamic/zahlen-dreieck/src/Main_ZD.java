import java.util.Arrays;

public class Main_ZD{

    public static void main(String[] args) {


        int [][] array = new int[7][7];
        initialisierung(array);
        int summe [][] =new int[array.length][array.length];
        summe[0][0] = array[0][0];
        for(int i=1; i<array.length;i++){
            for (int j=0;j<array.length;j++){
                if(j==0) summe[i][j] += array[i][j] + array[i-1][j];
                else {
                    int sum_a = summe[i-1][j-1] + array[i][j];
                    int sum_b = summe[i-1][j]+array[i][j];
                    if(max(sum_a,sum_b))
                        summe[i][j] = sum_a;
                    else
                        summe[i][j] = sum_b;
                }
            }
        }

        for(int i=0; i<array.length;i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(summe[i][j]+" ");
            }
            System.out.println();
        }
        int max = 0;
        for(int i = 0;i<summe.length;i++){
            if (summe[6][i]>max) {
                max = summe[6][i];
            }
        }
        System.out.println("Maxwert: "+ max );

    }

    public static boolean max(int a, int b){
        return (a > b) ? true: false;
    }



    public static void initialisierung(int array [][]){
        array[0][0] = 10;
        array[0][1] = 0;
        array[0][2] = 0;
        array[0][3] = 0;
        array[0][4] = 0;
        array[0][5] = 0;
        array[0][6] = 0;
        array[1][0] = 82;
        array[1][1] = 81;
        array[1][2] = 0;
        array[1][3] = 0;
        array[1][4] = 0;
        array[1][5] = 0;
        array[1][6] = 0;
        array[2][0] = 4;
        array[2][1] = 6;
        array[2][2] = 10;
        array[2][3] = 0;
        array[2][4] = 0;
        array[2][5] = 0;
        array[2][6] = 0;
        array[3][0] = 2;
        array[3][1] = 14;
        array[3][2] = 35;
        array[3][3] = 7;
        array[3][4] = 0;
        array[3][5] = 0;
        array[3][6] = 0;
        array[4][0] = 41;
        array[4][1] = 3;
        array[4][2] = 52;
        array[4][3] = 26;
        array[4][4] = 15;
        array[4][5] = 0;
        array[4][6] = 0;
        array[5][0] = 32;
        array[5][1] = 90;
        array[5][2] = 11;
        array[5][3] = 87;
        array[5][4] = 56;
        array[5][5] = 23;
        array[5][6] = 0;
        array[6][0] = 54;
        array[6][1] = 65;
        array[6][2] = 89;
        array[6][3] = 32;
        array[6][4] = 71;
        array[6][5] = 9;
        array[6][6] = 31;
    }

}