public class Exponentiell {


    public long expo(int basis, int exponent){

        if(exponent == 0){
            return 1;
        }
        if(exponent == 1) return basis;

        return basis * expo(basis,exponent-1);
    }
}
