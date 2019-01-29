import java.io.PrintStream;

public class Main_Spr {

    //Schritte die von einer Position mit einem Springer gemacht werden können --> 8 Schritte   (3,3) --> (1,2),(1,4),(2,1),(2,5),(4,1),(4,5),(5,2),(5,4)
    public static final int [] dx = {-2,-2,-1,-1, 1,1, 2,2};                                         //(x+dx[0],y+dy[0])
    public static final int [] dy = {-1, 1,-2, 2,-2,2,-1,1};

    public static void main(String[] args) {



        int [][] schachbrett = new int[5][5];
        int startRow = 1;
        int startCol = 1;
        schachbrett[startRow][startCol]=1;

        int [] xy = new int [2];
        xy[0] = startRow;
        xy[1] = startCol;

        int schritte = 1;

        while (findeLösung(schachbrett,5,5,xy)){
            schachbrett[xy[0]][xy[1]] = ++schritte;
        }

        //Ausgabe
        if(schritte == 5*5){
            for (int i = 0;i<5; i++){
                for (int j = 0; j<5; j++){
                    System.out.print(" "+schachbrett[i][j]);
                }
                System.out.println();
            }
        }else {
            System.out.println("keine Lösung");
        }



    }


    public static boolean findeLösung(int schachbrett [][], int m, int n, int [] xy){
        int rem = Integer.MAX_VALUE;
        int xn,yn,xx=0,yy=0;
        for(int i = 0; i< 8;i++){
            xn = xy[0] + dx[i];
            yn = xy[1] + dy[i];
            //überprüfe ob  neue Position auf dem Feld und ob das feld schon besucht wurde
            if(aufDemBrett(xn,yn,m,n) && schachbrett[xn][yn]==0){
                //überprüfe die nachfolger schritte und wähle die position mit der kleinsten Schrittzahl
                int schritte = nrSchritte(schachbrett,m,n,xn,yn);
                if(schritte<rem){
                    rem = schritte;
                    xx=xn;
                    yy=yn;
                }
            }
        }
        //setzte neuen Schritt mit x und y
        if(rem < Integer.MAX_VALUE) {
            xy[0] = xx;
            xy[1] = yy;
            return true;
        }
        return false;

    }


    public static int nrSchritte(int schachbrett [][], int m, int n, int x, int y){
        int xn,yn, schritte = 0;

        // von jedem schritt gibt es wieder 8 nachfolge Schritte beim Springer
        for (int i = 0; i<8; i++){
            xn = x + dx[i];
            yn = y + dy[i];
            //überprüfe ob  neue Position auf dem Feld und ob das feld schon besucht wurde
            if(aufDemBrett(xn,yn,m,n) && schachbrett[xn][yn] == 0){
                schritte++;
            }
        }
        return schritte;
    }

    public static boolean aufDemBrett(int xn, int yn, int m, int n){
        //wenn xn kleiner 0 dann ist x nicht auf dem Schachbrett, wenn xn größer m dann wäre x auch nicht af dem feld --> so bei yn äquivalent
        return (0<= xn && xn< m) && (0<=yn && yn < n);
    }

}
