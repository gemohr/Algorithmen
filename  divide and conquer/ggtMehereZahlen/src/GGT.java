public class GGT {


    public int ggt(int [] array, int l, int r ){


        if(l < r){
           int m =  (r+l)/2;
           int zahl1 = ggt(array,l,m);
           int zahl2 = ggt(array,m+1,r);
           return berechne(zahl1,zahl2);
        }
        return 0 <= l && l < array.length ? array[l] : 0;
    }

    public int berechne(int zahl1, int zahl2){

        while (zahl2 != 0) {
            int  rest = zahl1 % zahl2;
            zahl1 = zahl2;
            zahl2 = rest;
        }
        return zahl1;



    }



}
