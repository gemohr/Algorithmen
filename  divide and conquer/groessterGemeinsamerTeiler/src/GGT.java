public class GGT {

    public int ggt(int zahl1, int zahl2){

        if(zahl1 == 0)  return zahl2;
        if(zahl2 == 0)  return zahl1;

        int  rest = zahl1 % zahl2;
        zahl1 = zahl2;
        zahl2 = rest;

        if(zahl2 != 0) return ggt(zahl2,rest);
        return zahl1;


    }
}
