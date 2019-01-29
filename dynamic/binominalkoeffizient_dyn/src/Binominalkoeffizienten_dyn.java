public class Binominalkoeffizienten_dyn {


    int bin(int N,int K){
        //Standardfälle die nicht berechnet werden müssen sondern gleich einen wert liefern
        if (K == 0 || N == K)
            return 1;
        if (K == 1 || N == K + 1)
            return N;

        int [][] bino = new int[N+1][K+1];

        //Standartfall wenn 0 über 0 dann 1
        bino[0][0] = 1;

        for(int n = 1; n<=N; n++){
            //Standardfall wenn n über 0 dann 1
            bino[n][0]= 1;
            for (int k = 1; k<=K; k++){
                //standardfall wenn n über k dann 1 --> 2 über 2 = 1, 3 über 3 =1
                if(k == n) bino[n][k] = 1;
                else
                    //rekursionsformel
                bino[n][k] = bino[n-1][k] + bino[n-1][k-1];
            }
        }
        return bino[N][K];

    }

}
