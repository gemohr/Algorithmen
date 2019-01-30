public class Berechne {

    private int arrayGroeße;
    private long [] array;

    public Berechne(int arrayGroeße, long arr[]){
        this.arrayGroeße=arrayGroeße;
        this.array = arr;
    }



    public void berechne(){
        long [] p = new long[arrayGroeße+1];
        long [] q = new long[arrayGroeße+1];
        p[0] = -array[0];
        p[1] = 1;

        for (int k = 1; k<arrayGroeße; k++){
            q[0] = (-1) * p[0] * array[k];
            for (int j = 1; j<= k; j++){
                q[j] = p[j-1] - p[j] * array[k];
            }
            q[k + 1] = p[k];
            for(int j = 0;j<= k; j++) p[j] = q[j];
        }
        int x = 1;
        if(arrayGroeße % 2 != 0) x = -1;
        for (int k = 0; k <= arrayGroeße;k++){
            array[k] = x * p[k];
            x *= -1;
        }

    }

    private int sumZahlen(long nummer){
        int s = 0;
        while (nummer != 0){
            s+= nummer % 10;
            nummer /= 10;
        }
        return s;
    }

    void print(){
        for(int i = arrayGroeße -1 ;i >= 0; i--){
            System.out.print(sumZahlen(array[i]));
            System.out.print(" ");
            System.out.println(array[i]);

        }
    }

}
