public class Main_KG {
    public static void main(String[] args) {

         int [][] a = new int[7][7];
         int [] col = new int[7];

         a[0][0] = 0;
         a[0][1] = 1;
         a[0][2] = 1;
         a[0][3] = 1;
         a[0][4] = 0;
         a[0][5] = 0;
         a[0][6] = 1;

         a[1][0] = 1;
         a[1][1] = 0;
         a[1][2] = 1;
         a[1][3] = 1;
         a[1][4] = 0;
         a[1][5] = 0;
         a[1][6] = 0;

         a[2][0] = 1;
         a[2][1] = 1;
         a[2][2] = 0;
         a[2][3] = 1;
         a[2][4] = 1;
         a[2][5] = 0;
         a[2][6] = 1;

         a[3][0] = 1;
         a[3][1] = 1;
         a[3][2] = 1;
         a[3][3] = 0;
         a[3][4] = 1;
         a[3][5] = 0;
         a[3][6] = 1;

         a[4][0] = 0;
         a[4][1] = 0;
         a[4][2] = 1;
         a[4][3] = 1;
         a[4][4] = 0;
         a[4][5] = 1;
         a[4][6] = 1;

         a[5][0] = 0;
         a[5][1] = 0;
         a[5][2] = 0;
         a[5][3] = 0;
         a[5][4] = 1;
         a[5][5] = 0;
         a[5][6] = 1;

         a[6][0] = 1;
         a[6][1] = 0;
         a[6][2] = 1;
         a[6][3] = 1;
         a[6][4] = 1;
         a[6][5] = 1;
         a[6][6] = 0;

            //setze die erste farbe
            col [0] = 0;

            //durchlaufe die zeilen von 1 bis 6 --> 0:0 muss nicht da dies ja der anfangs wert ist und z.b. Deutschland nicht der nachbar von Deutschland sein kann
            for(int i = 1; i < 7; i++){
                // zähler für die Farben muss -1 sein da in der doWhile gleich auf 0 hochgezählt wird
                int j = -1;
                boolean ok = false;
                do {
                    j++;
                    ok=true;
                    // durch laufe die Spalten von 0 bis i und solange ok == true
                    for (int k = 0; ok && k < i; k++) {
                        //wenn ein Nachbar gefunden dann schaue ob die Farbe an der stelle k gleich der momentan ausgewählten farbe ist, wenn dies der fall ist kann der
                        if(1==a[k][i] && col[k] == j)
                        {ok = false;}

                    }
                }while (!ok);

                col[i]=j;
            }

            for (int l = 0;l<col.length;l++)
        System.out.println(col[l]+1);


    }
}
